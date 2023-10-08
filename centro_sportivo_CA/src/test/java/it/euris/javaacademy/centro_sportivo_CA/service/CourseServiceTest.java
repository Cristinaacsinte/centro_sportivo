package it.euris.javaacademy.centro_sportivo_CA.service;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Course;
import it.euris.javaacademy.centro_sportivo_CA.Entity.Customer;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustNotBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.repository.CourseRepository;
import it.euris.javaacademy.centro_sportivo_CA.utility.TestSupport;
import org.assertj.core.api.recursive.comparison.ComparingSnakeOrCamelCaseFields;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@SpringBootTest
class CourseServiceTest {


        @MockBean
        CourseRepository courseRepository;

        @Autowired
       CourseService courseService;

        @Test
        void shouldReturnACourse(){

            Course course = TestSupport.getCourse(1L);

            List<Course> courses = List.of(course);

            when(courseRepository.findAll()).thenReturn(courses);

            List<Course> returnedCustomers = courseService.findAll();

            assertThat(returnedCustomers)
                    .hasSize(1)
                    .first()
                    .usingRecursiveComparison()
                    .withIntrospectionStrategy(new ComparingSnakeOrCamelCaseFields())
                    .isEqualTo(course);
        }
    @Test
    void shouldInsertACourse(){

        Course course = TestSupport.getCourse(null);

        when(courseRepository.save(any())).thenReturn(course);

        Course returnedCourse = courseService.insert(course);
        assertThat(returnedCourse.getDenomination())
                .isEqualTo(course.getDenomination());
    }
    @Test
    void shouldNotInsertAnyCourse(){

       Course course = TestSupport.getCourse(1L);
        when(courseRepository.save(any())).thenReturn(course);

        assertThrows(IdMustBeNullException.class, () -> courseService.insert(course));

        assertThatThrownBy(() -> courseService.insert(course))
                .isInstanceOf(IdMustBeNullException.class);

    }
    @Test
    void shouldUpdateACourse(){

        Course course = TestSupport.getCourse(1L);

        when(courseRepository.save(any())).thenReturn(course);

        Course returnedCourse = courseService.update(course);
        assertThat(returnedCourse.getDenomination())
                .isEqualTo(course.getDenomination());
    }
    @Test
    void shouldNotUpdateAnyCourse(){

        Course course = TestSupport.getCourse(null);
        when(courseRepository.save(any())).thenReturn(course);

        assertThatThrownBy(() -> courseService.update(course))
                .isInstanceOf(IdMustNotBeNullException.class);
    }
    @Test
    void shouldDeleteACustomer() {
        //arrange
       Long id = 12L;

        doNothing().when(courseRepository).deleteById(anyLong());
        when(courseRepository.findById(id)).thenReturn(Optional.empty());
        assertTrue(courseService.deleteById(id));
        Mockito.verify(courseRepository, times(1)).deleteById(id);
    }

}