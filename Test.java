import java.util.*;
import junit.framework.TestCase;

public class Test extends TestCase {

	/**
	 * Performs a basic test on a simple table.
	 * gives input (a,b,c), a->c
	 * and expects output (a,c),(a,c) or any reordering
	 **/
	public void testSimpleBCNF() {
		//construct table
/*		AttributeSet attrs = new AttributeSet();
		attrs.addAttribute(new Attribute("a"));
		attrs.addAttribute(new Attribute("b"));
		attrs.addAttribute(new Attribute("c"));

		//create functional dependencies
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		AttributeSet ind = new AttributeSet();
		AttributeSet dep = new AttributeSet();
		ind.addAttribute(new Attribute("a"));
		dep.addAttribute(new Attribute("c"));
		FunctionalDependency fd = new FunctionalDependency(ind, dep);
		fds.add(fd);*/
		
		/*AttributeSet attrs = new AttributeSet();
		attrs.addAttribute(new Attribute("a"));
		attrs.addAttribute(new Attribute("b"));
		attrs.addAttribute(new Attribute("f"));*/
		/*attrs.addAttribute(new Attribute("d"));
		attrs.addAttribute(new Attribute("e"));
		attrs.addAttribute(new Attribute("f"));
		attrs.addAttribute(new Attribute("g"));
		attrs.addAttribute(new Attribute("h"));
		 */
		//create functional dependencies
		/*Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		AttributeSet ind = new AttributeSet();
		AttributeSet dep = new AttributeSet();
		ind.addAttribute(new Attribute("a"));
		ind.addAttribute(new Attribute("b"));
		dep.addAttribute(new Attribute("f"));
		//dep.addAttribute(new Attribute("g"));
		FunctionalDependency fd = new FunctionalDependency(ind, dep);
		fds.add(fd);
		ind = new AttributeSet();
		dep = new AttributeSet();
		ind.addAttribute(new Attribute("b"));
		dep.addAttribute(new Attribute("f"));*/
		//dep.addAttribute(new Attribute("f"));
		/*fd = new FunctionalDependency(ind, dep);
		fds.add(fd);
		ind = new AttributeSet();
		dep = new AttributeSet();
		ind.addAttribute(new Attribute("g"));
		dep.addAttribute(new Attribute("h"));
		fd = new FunctionalDependency(ind, dep);
		fds.add(fd);
		*/
		AttributeSet attrs = new AttributeSet();

		attrs.addAttribute(new Attribute("a"));

		attrs.addAttribute(new Attribute("b"));

		attrs.addAttribute(new Attribute("c"));

		attrs.addAttribute(new Attribute("d"));

		attrs.addAttribute(new Attribute("e"));
		

		//create functional dependencies

		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();

		AttributeSet ind = new AttributeSet();

		AttributeSet dep = new AttributeSet();

		ind.addAttribute(new Attribute("a"));

		dep.addAttribute(new Attribute("e"));
		FunctionalDependency fd = new FunctionalDependency(ind, dep);
		fds.add(fd);
		ind = new AttributeSet();

		dep = new AttributeSet();

		ind.addAttribute(new Attribute("b"));

		ind.addAttribute(new Attribute("c"));

		dep.addAttribute(new Attribute("a"));
		
		FunctionalDependency fd1 = new FunctionalDependency(ind, dep);
		fds.add(fd1);
		ind = new AttributeSet();

		dep = new AttributeSet();

		ind.addAttribute(new Attribute("d"));

		ind.addAttribute(new Attribute("e"));

		dep.addAttribute(new Attribute("b"));
		FunctionalDependency fd2 = new FunctionalDependency(ind, dep);
		fds.add(fd2);
		//run client code
		Set<AttributeSet> bcnf = BCNF.BCNF(attrs, fds);

		//verify output
		//assertEquals("Incorrect number of tables", 2, bcnf.size());

		for(AttributeSet as : bcnf) {
			System.out.println("hi"+ as.toString());
			//assertEquals("Incorrect number of attributes", 2, as.size());
			//assertTrue("Incorrect table", as.contains(new Attribute("a")));
		}
	
	}

}
