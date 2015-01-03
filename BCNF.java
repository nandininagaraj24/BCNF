import java.util.*;

public class BCNF {

	/**
	 * Implement your algorithm here
	 **/
	public static Set<AttributeSet> BCNF(AttributeSet attrs, Set<FunctionalDependency> fds) {
		int index=0, bitIndex=0;
		Integer[] checkBCNF = new Integer[fds.size()];
		System.out.println("FD SIZE is"+fds.size());
		for(int i =0;i<fds.size();i++){
				checkBCNF[i] = 0;
		}
		Set<AttributeSet> S = new HashSet<AttributeSet>();
		AttributeSet R = new AttributeSet(attrs);
		AttributeSet R1 = new AttributeSet();
		AttributeSet R2 = new AttributeSet();
		for(FunctionalDependency fd: fds)
		{
			System.out.println("For fd "+fd.dependent());
			System.out.println("For fd "+fd.independent());
			
			System.out.println("Closure returns : "+BCNF.closure(fd.independent(), fds).toString());
			System.out.println("My attrs are: "+attrs.toString());
			if(BCNF.closure(fd.independent(),fds).equals(attrs))
			{
				checkBCNF[index]=1;
				System.out.println("It is in BCNF");
			}
			index +=1;
		}

		
		for(FunctionalDependency fd: fds)
		{
			System.out.println("Index is" + bitIndex);
			if(checkBCNF[bitIndex]==0)
			{	
				System.out.println("Came in for fd:"+fd.independent().toString()+fd.dependent().toString());
				AttributeSet temp= new AttributeSet();
				temp.addAttributeSet(fd.independent());
				temp.addAttributeSet(fd.dependent());
				System.out.println("Value of Temp: "+temp.toString());
				S.add(temp);
				//for(AttributeSet a:fd.dependent()){
					
				 Iterator<Attribute> iter = fd.dependent().iterator();
				 //System.out.println("Attribute for remove is "+iter);
				 while(iter.hasNext())
				 {
					 Attribute result = iter.next();
					 System.out.println("tp removing "+result.toString());
					 
					 R2= R1.removeAttribute(R,result);
					System.out.println("After removing "+R2.toString());
				 }	
				
			}
			bitIndex++;
			
		}
		
		S.add(R);
		
		return S;
		
	}


	/**
	 * Recommended helper method
	 **/
	public static AttributeSet closure(AttributeSet attrs, Set<FunctionalDependency> fds) {
		//Initialization
				HashMap<String,Set<FunctionalDependency>> listAtt = new HashMap<String,Set<FunctionalDependency>>(); 
				HashMap<FunctionalDependency,Integer> countFD = new HashMap<FunctionalDependency, Integer>();
				AttributeSet newDep = new AttributeSet(attrs);
				AttributeSet update = new AttributeSet(attrs);
				
				HashMap<AttributeSet, AttributeSet> temp_update = new HashMap<AttributeSet, AttributeSet>();
				
				Iterator<FunctionalDependency> iter_fd = fds.iterator();
				while (iter_fd.hasNext())
				{
					FunctionalDependency fd = iter_fd.next();
					//Initialize count
					if(countFD.get(fd) != null)
						countFD.put(fd,fd.getIndepedent().size()+countFD.get(fd));
					else
						countFD.put(fd,fd.getIndepedent().size());
					
					//Initialize ListAtt
					AttributeSet tA = fd.getIndepedent();
					Iterator<Attribute> iter_attSet = tA.iterator();
					while(iter_attSet.hasNext())
					{
						Attribute att = iter_attSet.next();
						if(fd.getIndepedent().contains(att))
						{
							Set<FunctionalDependency> fdSet = new HashSet<FunctionalDependency>();
							fdSet.add(fd);
							listAtt.put(att.toString(),fdSet);
						}
					}
				}
				
				//Computation
				while(update.size()!=0)
				{
					Iterator<Attribute> itr = update.iterator();
					//List<Attribute> Att = update.getAttributeSet();
					while( itr.hasNext())
					{
						Attribute att_del = itr.next();
						//if(Att.contains(att_del)){
						AttributeSet R1 = new AttributeSet();
				  	    AttributeSet R2 = new AttributeSet();

							update = R1.removeAttribute(R2,att_del);
						//}
							//update.removeAttribute(att_del);
						Set<FunctionalDependency> fdSet = listAtt.get(att_del.toString());
						if(fdSet != null && fdSet.size() != 0)
						{
							Iterator<FunctionalDependency> iter_fd2 = fdSet.iterator();
							FunctionalDependency fd2 = iter_fd2.next();
							System.out.println(" count "+countFD.get(fd2));
							int new_count = countFD.get(fd2) - 1;
							countFD.put(fd2,new_count);
							if(new_count == 0)
							{
								AttributeSet Add = fd2.getDependent();
		
								AttributeSet R3 = new AttributeSet();
								AttributeSet R4 = new AttributeSet();

								Iterator<Attribute> iter_attSet2 = newDep.iterator();
								while(iter_attSet2.hasNext())
									R4 = R3.removeAttribute(Add ,iter_attSet2.next());
								
								Iterator<Attribute> iter_attSet3 = Add.iterator();
								while(iter_attSet3.hasNext())
								{
									Attribute att3 = iter_attSet3.next();
									newDep.addAttribute(att3);
									update.addAttribute(att3);
								}
							}
						}
					}
				}
				
				return newDep;
			}    
}
