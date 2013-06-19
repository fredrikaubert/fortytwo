package no.parasit.fortytwo

    import org.junit.Test

class TrafikantenRestServiceTest {


   TrafikantenRestService service = new TrafikantenRestService()


    @Test
    void testRestService() {
        service.getDeparturesInfo()
    }


}
