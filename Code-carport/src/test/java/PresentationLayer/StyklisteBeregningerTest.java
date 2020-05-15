package PresentationLayer;

import FunctionLayer.Materials;
import org.junit.Test;

import static java.lang.Math.pow;
import static org.junit.Assert.*;

public class StyklisteBeregningerTest {

    @Test
    public void calculateVinskederLength() {
        int width = 550;
        int slopeAngle = 15;
        double hosliggende = (width / 2);
        double modstående = hosliggende * (Math.tan(Math.toRadians(slopeAngle)));
        double hypo = Math.sqrt(Math.pow(modstående, 2.0) + Math.pow(hosliggende, 2.0));
        double vinskederLength = 2 * hypo;

        assertEquals(569.4, vinskederLength, 0.1);
    }

    @Test
    public void calculateRoofWood() {
    }

    @Test
    public void calculateCladdingSide() {
    }

    @Test
    public void calculateCladdingFront() {
    }

    @Test
    public void totalPlankerSkur() {
    }

    @Test
    public void calculateStolper() {
        int stolperAntalLength = 2;
        int stolperAntalWidth = 2;
        int length = 600;
        int width = 550;
        int height = 390;

        if (length > 420 && length <= 630) {
            stolperAntalLength += 1;
        } else if (length > 630) {
            stolperAntalLength += 2;
        }
        if (width > 520) {
            stolperAntalWidth += 1;
        }
        int antalStolper = stolperAntalLength * stolperAntalWidth;
        int cmStolpe = height * antalStolper;

        int stolpe1Length = 300;
        int stolpe2Length = 150;

        int stolpeMath1 = cmStolpe / stolpe1Length;
        int stolpeExtra1 = cmStolpe % stolpe1Length;
        int stolpeMath2 = stolpeExtra1 / stolpe2Length;
        int stolpeExtra2 = stolpeExtra1 % stolpe2Length;

        if (stolpeExtra2 > 0) {
            stolpeMath2 += 1;
        }

        assertEquals(11, stolpeMath1);
        assertEquals(2, stolpeMath2);
    }

    @Test
    public void calculateRem() {
        int length = 600;
        int maxRemLength = length * 3;

        int rem1Length = 270;
        int rem2Length = 240;

        int remMath1 = maxRemLength / rem1Length;
        int remExtra1 = maxRemLength % rem1Length;
        int remMath2 = remExtra1 / rem2Length;
        int remExtra2 = remExtra1 % rem2Length;

        if (remExtra2 > 0) {
            remMath2 += 1;
        }

        assertEquals(6, remMath1);
        assertEquals(1, remMath2);

    }

    @Test
    public void calculateSpaerFladtTag() {
        int length = 600;
        int width = 550;
        int spaerAntalRaekker = length / 80; // 80 er den længde der skal være mellem spær
        int maxSpaerLength = spaerAntalRaekker * width;

        int spaer1Length = 600;
        int spaer2Length = 480;

        int spaerMath1 = maxSpaerLength / spaer1Length;
        int spaerExtra1 = maxSpaerLength % spaer1Length;
        int spaerMath2 = spaerExtra1 / spaer2Length;
        int spaerExtra2 = spaerExtra1 % spaer2Length;

        if (spaerExtra2 > 0) {
            spaerMath2 += 1;
        }

        assertEquals(6, spaerMath1);
        assertEquals(1, spaerMath2);
    }

    @Test
    public void calculateSpaerRejsning() {
        int length = 600;
        int width = 550;
        int spaerAntalRaekker = length / 80; // 80 er den længde der skal være mellem spær
        double hypotenusenx2 = 569.4;
        int maxSpaerLength = ((int) hypotenusenx2 + width) * spaerAntalRaekker;

        int spaer1Length = 600;
        int spaer2Length = 480;

        int spaerMath1 = maxSpaerLength / spaer1Length;
        int spaerExtra1 = maxSpaerLength % spaer1Length;
        int spaerMath2 = spaerExtra1 / spaer2Length;
        int spaerExtra2 = spaerExtra1 % spaer2Length;

        if (spaerExtra2 > 0) {
            spaerMath2 += 1;
        }

        assertEquals(13, spaerMath1);
        assertEquals(1, spaerMath2);
    }
}