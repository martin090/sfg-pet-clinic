package com.martinsanguin.sfgpetclinic.services.springdatajpa;

import com.martinsanguin.sfgpetclinic.model.Owner;
import com.martinsanguin.sfgpetclinic.repositories.OwnerRepository;
import com.martinsanguin.sfgpetclinic.repositories.PetRepository;
import com.martinsanguin.sfgpetclinic.repositories.PetTypeRepository;
import com.martinsanguin.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";

    Owner ownerReturn;

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerService;

    @BeforeEach
    void setUp() {
        ownerReturn = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findOwnerByLastName(any())).thenReturn(ownerReturn);
        Owner owner = ownerService.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME,owner.getLastName());
        verify(ownerRepository).findOwnerByLastName(any());
    }

    @Test
    void findAll() {
        HashSet<Owner> ownerSet = new HashSet<>();
        ownerSet.add(ownerReturn);
        when(ownerRepository.findAll()).thenReturn(ownerSet);
        assertEquals(1,ownerService.findAll().size());
        verify(ownerRepository).findAll();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(ownerReturn));
        assertNotNull(ownerService.findById(1L));
    }

    @Test
    void findByIdNotFounded() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertNull(ownerService.findById(4L));
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(3L).build();
        when(ownerRepository.save(any())).thenReturn(ownerToSave);
        Owner savedOwner = ownerService.save(ownerToSave);
        assertEquals(3L,savedOwner.getId());
        verify(ownerRepository).save(any()); //To verify that a mock interaction occurred.
    }

    @Test
    void delete() {
        ownerService.delete(ownerReturn);
        verify(ownerRepository,times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(1L);
        verify(ownerRepository,times(1)).deleteById(anyLong());
    }
}