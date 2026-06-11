package generics_extra.model;

import java.util.Comparator;

public class LPAComparator implements Comparator<LPAStudent> {

    @Override
    public int compare(LPAStudent s1, LPAStudent s2) {
        return Double.compare(s1.getPercentComplete(), s2.getPercentComplete());
    }

}
