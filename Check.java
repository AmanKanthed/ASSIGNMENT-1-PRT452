import kanthed.CycleGraph;
import org.junit.Test;

public class Check {

	@Test
	public void test() {
		// CycleGraph g1 = new CycleGraph(2); TEST FAILS
		CycleGraph g1 = new CycleGraph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.connected())
            System.out.println("Connected");
        else
            System.out.println("Not Connected");
        // CycleGraph g2 = new CycleGraph(3); TEST FAILS
        CycleGraph g2 = new CycleGraph(6);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);
 
        if (g2.connected())
            System.out.println("Connected");
        else
            System.out.println("Not Connected");
 
    }
	}