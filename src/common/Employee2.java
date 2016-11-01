package common;

import org.apache.commons.lang3.builder.CompareToBuilder;

/**
 * This class represents an Employee object that will be sorted by default
 * using its "natural order," defined in this case to be by empID.
 * 
 * Note that this example DOES use Generics.
 * 
 * Also note that the field used for equals and hashCode (empId) is the same as
 * the one chose for sorting. This is the recommended approach for the default
 * sort order.
 * 
 * @author jlombardo
 */
public class Employee2 implements Comparable<Employee2> {
    private int empID;
    private String lastName;
    private String firstName;
    private String ssn;


    public Employee2() {
    }

    public Employee2(int empID, String lastName, String firstName, String ssn) {
        this.empID = empID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.ssn = ssn;
        this.empID = empID;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee2 other = (Employee2) obj;
        if (this.empID != other.empID) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.empID;
        return hash;
    }


    public int compareTo(Employee2 other) {
        
        // Using a utility from Apache Commons
        return new CompareToBuilder()
               .append(this.empID, other.empID)
               .toComparison();
        
        
//        // NO Magic numbers! Use constants for readability!
//        final int BEFORE = -1;
//	final int EQUAL = 0;
//	final int AFTER = 1;
//
//        Employee e = (Employee)other;
//
//        if(this.equals(e)) return EQUAL;
////
////        if(this.empID > e.empID) return BEFORE;
////        if(this.empID < e.empID) return AFTER;
//
//        // The String class already has a compareTo implementation, so
//        // just use that.
//        int comparison = this.ssn.compareTo(e.getSsn());
//        if( comparison != EQUAL) return comparison;
//
//        return EQUAL; // default
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) throws IllegalArgumentException {
            if(value == null || value.length() == 0) {
                    throw new IllegalArgumentException("value cannot be null or zero length");
            }
            firstName = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmpID(int id) {
        this.empID = id;
    }

    public int getEmpID() {
        return empID;
    }

    @Override
    public String toString() {
        return "Employee{" + "empID=" + empID + ", lastName=" + lastName + ", firstName=" + firstName + ", ssn=" + ssn + '}';
    }

}
