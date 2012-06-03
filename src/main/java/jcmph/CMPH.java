package jcmph;

import static java.util.Arrays.asList;

public class CMPH {

  public CMPH() {
  	String[] keys = {
		"aaaaaaaaaa",
		"bbbbbbbbbb",
		"cccccccccc",
		"dddddddddd",
		"eeeeeeeeee",
		"ffffffffff",
		"gggggggggg",
		"hhhhhhhhhh",
		"iiiiiiiiii",
		"jjjjjjjjjj"
	};
	for (String key : keys) {
		System.out.println("in java: " + init("/tmp/keys.mph", key));
	}
  }

  private native int init(String hashFunctionFile, String key);

  /*
  public <T> HashFunction createHashFor(T... objects) {
	  return new HashSet<T>(asList(objects));
  }
  
  public <T> HashFunction createHashFor(Set<T> objects) {
	  return null;
  }

  public static class HashFunction {
	  
	  public int hash(Object object) {
		  return g(object.hashCode());
	  }
		  
	  private int g(int i) {
		  return i;
	  }
	  
  }
  */

  static {
    System.loadLibrary("jcmph_CMPH");
  }
}
