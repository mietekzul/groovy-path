package db

import org.junit.Test
import pl.raziel.db.StoredProcedureService

class StoredProcedureServiceTest {
    StoredProcedureService service = new StoredProcedureService()

    @Test
    void testGetFilmsInStock() {
        assert 4 == service.getFilmsInStock(1, 1)
    }

    @Test
    void testGetFilmsInStockWithClosure() {
        service.getFilmsInStock(1, 1) { count -> assert count == 4 }
    }
}