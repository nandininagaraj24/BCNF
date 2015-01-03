import java.util.*;

/**
 * An unordered set of Attributes. This could very easily be a Java collection,
 * but an important operation (namely examining the powerset) is not easily done
 * with the Java collection.
 **/
public class AttributeSet {

	//a list of the backing attributes
	private List<Attribute> attr;

	//construct an empty AttributeSet
	public AttributeSet() {
		attr = new ArrayList<Attribute>();
	}

	//copy constructor
	public AttributeSet(AttributeSet other) {
		attr = new ArrayList<Attribute>(other.attr);
	}

	public void addAttribute(Attribute a) {
		if(!attr.contains(a))
			attr.add(a);
	}

	public boolean contains(Attribute a) {
		return attr.contains(a);
	}

	public int size() {
		return attr.size();
	}

	public List<Attribute> getAttributeSet(){
		return this.attr;
	}


	public boolean equals(Object other) {
		if(other == null || !(other instanceof AttributeSet))
			return false;
		
		boolean notMatch = false; 
		
		AttributeSet p_object = (AttributeSet)other;
		Iterator<Attribute> p_it = p_object.iterator();
		while(p_it.hasNext())
		{
			if(!attr.contains(p_it.next()))
				notMatch = true;			
		}
		if(notMatch)
			return false;
		else
			return true;

	}

	public Iterator<Attribute> iterator() {
		return attr.iterator();
	}

	public AttributeSet removeAttribute(AttributeSet R,Attribute a){
		
		Iterator<Attribute> iter = R.iterator();
	    while(iter.hasNext()){
		  	if(iter.next().equals(a)){
		  		iter.remove();
		  	}
	    }
	    return R;
	}
	
	public String toString() {
		String out = "";
		Iterator<Attribute> iter = iterator();
		while(iter.hasNext())
			out += iter.next() + "\t";

		return out;
	}

	public void addAttributeSet(AttributeSet a) {
	   	for(Attribute t:a.getAttrList()){
	   		attr.add(t);
	   	}		   	
	}
	
	public List<Attribute> getAttrList()
	{
		return this.attr;
	}
	
}
