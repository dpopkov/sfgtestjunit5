package learn.sfg.sfgtestjunit5.controllers;

import learn.sfg.sfgtestjunit5.ControllerTests;
import learn.sfg.sfgtestjunit5.fauxspring.ModelMapMockImpl;
import learn.sfg.sfgtestjunit5.model.Speciality;
import learn.sfg.sfgtestjunit5.model.Vet;
import learn.sfg.sfgtestjunit5.services.map.SpecialityMapService;
import learn.sfg.sfgtestjunit5.services.map.VetMapService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest implements ControllerTests {

    private VetMapService vetService;

    @BeforeEach
    void setUp() {
        final SpecialityMapService specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);
        Set<Speciality> specialities = new HashSet<>();
        specialities.add(new Speciality(1L, "spec-1"));
        specialities.add(new Speciality(2L, "spec-2"));
        vetService.save(new Vet(1L, "vet-name-1", "vet-last-name-1", specialities));
        vetService.save(new Vet(2L, "vet-name-2", "vet-last-name-2", specialities));
    }

    @Test
    void testListVets() {
        VetController controller = new VetController(vetService);
        ModelMapMockImpl modelMock = new ModelMapMockImpl();

        final String viewName = controller.listVets(modelMock);

        assertEquals("vets/index", viewName);
        @SuppressWarnings("unchecked")
        final Set<Vet> vets = (Set<Vet>) modelMock.getAttribute("vets");
        assertEquals(2, vets.size());
        Assertions.assertThat(vets).anyMatch(v -> v.getFirstName().equals("vet-name-1"));
        Assertions.assertThat(vets).anyMatch(v -> v.getFirstName().equals("vet-name-2"));
    }
}
