package dev.hoteals.web_app_sandbox.Controller;

import dev.hoteals.web_app_sandbox.Model.Car;
import dev.hoteals.web_app_sandbox.Model.Person;
import dev.hoteals.web_app_sandbox.Service.CarService;
import dev.hoteals.web_app_sandbox.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Objects;

@Controller
public class HomeController
{
    //region Person
    @Autowired
    PersonService personService;


    @GetMapping("/person")
    public String person(Model model)
    {
        List<Person> personList = personService.fetchAll();
        model.addAttribute("personList", personList);
        return "/home/person";
    }

    @PostMapping("/addPerson")
    public String addPerson ( @ModelAttribute Person person ){
        personService.addPerson( person );
        return "redirect:/person";
    }

    @PostMapping("/deletePerson")
    public String deletePerson (WebRequest wr) {
        int personID = Integer.parseInt(Objects.requireNonNull(wr.getParameter("personID")));
        Boolean deleted = personService.deletePerson(personID);
        return "redirect:/person";
    }

    @PostMapping("/editPerson")
    public String editPerson(Model model, WebRequest wr)
    {
        Person person = personService.findPersonByID(Integer.parseInt(Objects.requireNonNull(wr.getParameter("personID"))));
        model.addAttribute("person", person);
        return "/home/editPerson";
    }

    @PostMapping("/savePerson")
    public String savePerson (WebRequest wr) {
        String firstName = wr.getParameter("firstName");
        String lastName = wr.getParameter("lastName");
        int personID = Integer.parseInt(Objects.requireNonNull(wr.getParameter("personID")));
        Person person = new Person ( personID, firstName, lastName );
        personService.updatePerson(person);
        return "redirect:/person";
    }
    //endregion

    //region Car
    @Autowired
    CarService carService;

    @GetMapping("/car")
    public String car(Model model)
    {
        List<Car> carList = carService.fetchAll();
        model.addAttribute("carList", carList);
        return "/home/car";
    }

    @PostMapping("/addCar")
    public String addCar( @ModelAttribute Car car ) {
        carService.addCar(car);
        return "redirect:/car";
    }

    @PostMapping("/deleteCar")
    public String deleteCar (WebRequest wr) {
        int carID = Integer.parseInt(Objects.requireNonNull(wr.getParameter("carID")));
        carService.deleteCar(carID);
        return "redirect:/car";
    }

    @PostMapping("/editCar")
    public String editCar(Model model, WebRequest wr)
    {
        int carID = Integer.parseInt(Objects.requireNonNull(wr.getParameter("carID")));
        Car car = carService.findCarByID(carID);
        model.addAttribute("car", car);
        return "/home/editCar";
    }

    @PostMapping("/saveCar")
    public String saveCar (WebRequest wr){
        int carID = Integer.parseInt(Objects.requireNonNull(wr.getParameter("carID")));
        String brand = wr.getParameter("brand");
        String model = wr.getParameter("model");
        String color = wr.getParameter("color");
        Car car = new Car (carID, brand, model, color);
        carService.updateCar(car);
        return "redirect:/car";
    }
    //endregion
}
