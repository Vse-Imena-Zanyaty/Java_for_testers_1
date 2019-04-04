package soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class GeoIPserviceTests {

  @Test
  public void testMyIP() {
    String geoIP = new GeoIPService().getGeoIPServiceSoap12().getIpLocation20("83.102.134.124");
    assertThat(geoIP, containsString("<Country>RU</Country>"));
  }

  @Test(enabled = false)
  public void testInvalidIP() {
    String geoIP = new GeoIPService().getGeoIPServiceSoap12().getIpLocation20("83.102.134.xxx");
    assertThat(geoIP, containsString("<Country>RU</Country>"));
  }
}
