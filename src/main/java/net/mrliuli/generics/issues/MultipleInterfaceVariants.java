package net.mrliuli.generics.issues;

import net.mrliuli.generics.wildcards.Holder;

/**
 * Created by leon on 2017/12/9.
 */
public class MultipleInterfaceVariants {
}
interface Payable<T>{}
class Employee implements Payable<Employee>{}
//class Hourly extends Employee implements Payable<Holder>{}