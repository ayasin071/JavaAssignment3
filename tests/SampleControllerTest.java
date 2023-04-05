package tests;

package unittesting;

import controller.SampleController;
import model.Toy;

public class SampleControllerTest {
    @Test
    public void testSaveHandler() {
        SampleController controller = new SampleController();
        controller.cbCategory.setValue("Figure");
        controller.tfSN.setText("123");
        controller.tfName.setText("Test Figure");
        controller.tfBrand.setText("Test Brand");
        controller.tfPrice.setText("10.0");
        controller.tfAvailCount.setText("5");
        controller.tfAgeAppr.setText("10");
        controller.tfClass.setText("Test Classification");

        controller.btnSaveHandler(null);

        assertEquals(1, controller.sm.getInventory().size());
        Toy savedToy = controller.sm.getInventory().get(0);
        assertEquals("123", savedToy.getSerialNumber());
        assertEquals("Test Figure", savedToy.getName());
        assertEquals("Test Brand", savedToy.getBrand());
        assertEquals(10.0, savedToy.getPrice());
        assertEquals(5, savedToy.getAvailableCount());
        assertEquals(10, savedToy.getAgeAppropriate());
        assertTrue(savedToy instanceof Figures);
        Figures savedFigure = (Figures) savedToy;
        assertEquals("Test Classification", savedFigure.getClassification());
    }
}

