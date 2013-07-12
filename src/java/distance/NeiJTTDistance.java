/**
 *
 * NeiJTTDistance.java
 * 
 * Uses Nei's ignore all columns with gaps on a global basis.
 * Uses JTT pairwise distance (number of columns with differing 
 * characters) given Nei's global gap (omission) treatment.
 */



public class NeiJTTDistance extends NeiDistance {

    protected void initializeSimpleDistance () {
	simpleDistance = new SimpleJTTDistance();
    }



    // um ok
    public static void test1 () {
	String x = "ACTG---TACGCTAGA--AGACGAT--ACAGATC--A--AC";
	String y = "AAAAAGCTAATCTAGA--AGAGGAT--AGAGTTC-----AC";
	Sequence xs = new Sequence(); xs.sequence = x;
	Sequence ys = new Sequence(); ys.sequence = y;
	boolean[] columnsToIgnore = new boolean[x.length()];
	columnsToIgnore[2] = true;
	NeiJTTDistance d = new NeiJTTDistance ();
	Sequence[] seqs = new Sequence[2];
	seqs[0] = xs;
	seqs[1] = ys;
	double[][] result = d.getDistanceMatrix(seqs);
	System.out.println ("distance is: |" + result[0][1] + "|");
    }

    public static void main (String[] args) {
	test1();
    }
}
