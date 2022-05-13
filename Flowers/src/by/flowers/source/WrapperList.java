package by.flowers.source;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import by.flowers.bean.Wrapper;

public class WrapperList {

    private List<Wrapper> wrapperList = new ArrayList<Wrapper>();
    
    public WrapperList() {}

    public WrapperList(List<Wrapper> wrapperList) {
	this.wrapperList = wrapperList;
    }

    public List<Wrapper> getWrapperList() {
        return wrapperList;
    }

    public void setPackageList(List<Wrapper> wrapperList) {
        this.wrapperList = wrapperList;
    }

    @Override
    public int hashCode() {
	return Objects.hash(wrapperList);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	WrapperList other = (WrapperList) obj;
	return Objects.equals(wrapperList, other.wrapperList);
    }

    @Override
    public String toString() {
	String str = "";
	for(Wrapper f: wrapperList) {
	    str += f.toString() + "\n";
	}
	return str;
    }


    
    
}
