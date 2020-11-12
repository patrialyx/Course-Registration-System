package stars;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentRegisteredCourses implements Serializable{
    ArrayList<Index> waitlistedIndexArray;
    ArrayList<Index> confirmedIndexArray;
    Student owner; 
    int AU;

    public StudentRegisteredCourses(Student owner) {
        this.owner = owner;
        waitlistedIndexArray = new ArrayList<Index>();
        confirmedIndexArray = new ArrayList<Index>();
    }

    public ArrayList<Index> getIndexList() {
        ArrayList<Index> temp = (ArrayList<Index>)this.waitlistedIndexArray.clone();
        temp.addAll(this.confirmedIndexArray);
        return temp;
    }
    
    public ArrayList<Index> getWaitlistedIndexArray() {
        return waitlistedIndexArray;
    }
    
    public ArrayList<Index> getConfirmedIndexArray() {
        return confirmedIndexArray;
    }

    public int getAU() {
        return AU;
    }

    public void addAU(int au) {
        this.AU += au;
    }

    public void addToConfirmedIndexArray(Index index) {
        confirmedIndexArray.add(index);
    }

    public void addToWaitlistedIndexArray(Index index) {
        waitlistedIndexArray.add(index);
    }

    public void removeFromConfirmedIndexArray(Index index) {
        confirmedIndexArray.remove(index);
    }

    public void removeFromWaitlistedIndexArray(Index index) {
        waitlistedIndexArray.remove(index);
    }

    public void moveToConfirmed(Index index){
        confirmedIndexArray.add(index);
        waitlistedIndexArray.remove(index);
    }
    
    public Student getOwner() {
        return owner;
    }

    public boolean addIndex(Index index) {
        IndexStudentAdder indexStudentAdder = new IndexStudentAdder();
        boolean success = indexStudentAdder.addStudent(index, this);
        return success;
        // boolean confirmed, success;
        // success = checkClash(index);
        // if (!success) {
        //     return false;
        // }
        // confirmed = index.addStudent(this.owner);
        // if (confirmed) {
        //     this.confirmedIndexArray.add(index);
        // } else {
        //     this.waitlistedIndexArray.add(index);
        // }
        // return true;
    }

    public boolean dropIndex(Index index) {
        IndexStudentDropper indexStudentDropper = new IndexStudentDropper();
        boolean success = indexStudentDropper.dropStudent(index, this);
        return success;
        // boolean confirmed;
        // confirmed = index.dropStudent(this.owner);
        // if (confirmed) {
        //     this.confirmedIndexArray.remove(index);
        // } else {
        //     this.waitlistedIndexArray.remove(index);
        // }
        // return true;
    }
    
    // public boolean checkChangeIndex(Index oldIndex, Index newIndex){
    //     boolean success;
    //     if (this.waitlistedIndexArray.remove(oldIndex)) {
    //         success = checkClash(newIndex);
    //         this.waitlistedIndexArray.add(oldIndex);
    //         return success;
    //     } else {
    //         this.confirmedIndexArray.remove(oldIndex) ;
    //         success = checkClash(newIndex);
    //         this.confirmedIndexArray.add(oldIndex);
    //         return success;
    //     }

    // }
    
    public boolean changeIndex(Index oldIndex, Index newIndex) {
        TimetableClashChecker clashChecker = new TimetableClashChecker();
        boolean allowed = clashChecker.checkClash(this, newIndex, oldIndex);
        if (allowed) {
            IndexStudentAdder adder = new IndexStudentAdder();
            IndexStudentDropper dropper = new IndexStudentDropper();
            dropper.dropStudent(oldIndex, this);
            adder.addStudent(newIndex, this);
        }
        return allowed;
    }

    public void swopPlaces(Index friendIndex, Student friend) {
        IndexStudentSwopper swopper = new IndexStudentSwopper();
        swopper.swopStudent(friendIndex, friend, this.owner);
        // boolean confirmed;
        // confirmed = friendIndex.swopStudent(friend, this.owner);
        // if (confirmed) {
        //     this.confirmedIndexArray.add(friendIndex);
        // } else {
        //     this.waitlistedIndexArray.add(friendIndex);
        // }
    }
}
