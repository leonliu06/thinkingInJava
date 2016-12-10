package biz.superalloy;
//import java.*;
import java.util.List;

interface Payable<T> {}

class Employee implements Payable<Employee> {}

//class Hourly extends Employee implements Payable<Hourly> {
class Hourly implements Payable<Hourly> {

}

//由于擦除的原因，重载方法将产生相同的类型签名
class UseList<W, T>{
	void f(List<T> v){}
	//void f(List<W> w){}
}


class UseList2<W, T>{
	void f1(List<T> v){}
	void f2(List<W> w){}
}