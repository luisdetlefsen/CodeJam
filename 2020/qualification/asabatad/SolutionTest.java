package codejam.qualification.asabatad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {


    @Test
    public void testComp() {
        boolean bo1 = true, bo2 = false;
        boolean bn1 = false, bn2 = true;
        boolean bo3 = true, bo4 = true;
        boolean bn3 = false, bn4 = false;
        Solution.FLUX result = Solution.determineFLux(bo1, bo2, bn1, bn2, bo3, bo4, bn3, bn4);

        assertEquals(Solution.FLUX.COMPLEMENT, result);

        result = Solution.determineFLux(!bo1, !bo2, !bn1, !bn2, !bo3, !bo4, !bn3, !bn4);
        assertEquals(Solution.FLUX.COMPLEMENT, result);

    }

    @Test
    public void testReverse() {
        boolean bo1 = true, bo2 = false;
        boolean bn1 = false, bn2 = true;
        boolean bo3 = true, bo4 = true;
        boolean bn3 = true, bn4 = true;
        Solution.FLUX result = Solution.determineFLux(bo1, bo2, bn1, bn2, bo3, bo4, bn3, bn4);

        assertEquals(Solution.FLUX.REVERSE, result);

        result = Solution.determineFLux(!bo1, !bo2, !bn1, !bn2, !bo3, !bo4, !bn3, !bn4);
        assertEquals(Solution.FLUX.REVERSE, result);
    }

    @Test
    public void testReverseComp() {
        boolean bo1 = true, bo2 = false;
        boolean bn1 = true, bn2 = false;
        boolean bo3 = true, bo4 = true;
        boolean bn3 = false, bn4 = false;
        Solution.FLUX result = Solution.determineFLux(bo1, bo2, bn1, bn2, bo3, bo4, bn3, bn4);

        assertEquals(Solution.FLUX.COMPLEMENT_REVERSE, result);

        result = Solution.determineFLux(!bo1, !bo2, !bn1, !bn2, !bo3, !bo4, !bn3, !bn4);
        assertEquals(Solution.FLUX.COMPLEMENT_REVERSE, result);
    }

    @Test
    public void testNothing() {
        boolean bo1 = true, bo2 = false;
        boolean bn1 = true, bn2 = false;
        boolean bo3 = true, bo4 = true;
        boolean bn3 = true, bn4 = true;
        Solution.FLUX result = Solution.determineFLux(bo1, bo2, bn1, bn2, bo3, bo4, bn3, bn4);

        assertEquals(Solution.FLUX.NOTHING, result);

        result = Solution.determineFLux(!bo1, !bo2, !bn1, !bn2, !bo3, !bo4, !bn3, !bn4);
        assertEquals(Solution.FLUX.NOTHING, result);
    }

}
