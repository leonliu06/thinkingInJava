// InheritInner.java
// Inheriting an inner class.
class WithInner{
    class Inner{}
}
public class InheritInner extends WithInner.Inner{
    // InheritInner(){} // Won't compile
    InheritInner(WithInner wi){
        wi.super(); // 显式调用外围类构造函数
    }
	public static void main(String[] args){
		WithInner wi = new WithInner();
		InheritInner ii = new InheritInner(wi);
	}
}