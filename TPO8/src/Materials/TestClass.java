package Materials;
import java.io.Serializable;

//Task was do not use simple types (primitives or strings) so I created a class for it.

public class TestClass implements Serializable{
	
	private static final long serialVersionUID = -1588287692925817841L;
	
	String echo = null;
	long a = 0;
	long b = 0;
	
	public String getEcho() {
		return echo;
	}
	public void setEcho(String echo) {
		this.echo = echo;
	}
	public long getA() {
		return a;
	}
	public void setA(long a) {
		this.a = a;
	}
	public long getB() {
		return b;
	}
	public void setB(long b) {
		this.b = b;
	}
	
}
