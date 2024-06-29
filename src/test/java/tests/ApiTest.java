package tests;

import api.BaseApiTest;
import api.Device;
import api.DeviceService;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ApiTest extends BaseApiTest {
    DeviceService deviceService = new DeviceService();
    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void setUp() {
        extent = ExtentManager.getInstance();
    }

    @Test
    public void addNewDeviceTest() {
        test = extent.createTest("addNewDeviceTest");
        test.info("Starting addNewDeviceTest");

        Map<String, Object> deviceData = new HashMap<>();
        deviceData.put("year", 2023);
        deviceData.put("price", 7999.99);
        deviceData.put("CPU model", "Apple ARM A7");
        deviceData.put("Hard disk size", "1 TB");

        Device device = new Device("Apple Max Pro 1TB", deviceData);

        var response = deviceService.addDevice(device);

        try {
            Assert.assertEquals(response.statusCode(), 200);
            Device addedDevice = response.as(Device.class);
            Assert.assertNotNull(addedDevice.getId());
            Assert.assertNotNull(addedDevice.getCreatedAt());
            Assert.assertEquals(addedDevice.getName(), "Apple Max Pro 1TB");
            Assert.assertEquals(addedDevice.getData().get("year"), 2023);
            Assert.assertEquals(addedDevice.getData().get("price"), 7999.99);
            Assert.assertEquals(addedDevice.getData().get("CPU model"), "Apple ARM A7");
            Assert.assertEquals(addedDevice.getData().get("Hard disk size"), "1 TB");
            test.pass("addNewDeviceTest passed");
        } catch (AssertionError e) {
            test.fail("addNewDeviceTest failed");
            throw e;
        }
    }

    @AfterClass
    public void tearDown() {
        extent.flush();
    }
}
