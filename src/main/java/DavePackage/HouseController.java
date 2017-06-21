package DavePackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;


@Controller
public class HouseController {

    @Autowired
    HouseRepository houseRepository;

    @RequestMapping(value = "/home", method = RequestMethod.GET) //@GetRequest
    public String getIt(Model model){
        System.out.println("GET TEst");
        model.addAttribute(new House());

        return  "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String ProcessHouse(@ModelAttribute House house){
        System.out.println("GET TEst");
        houseRepository.save(house);
        return "redirect:/display";
    }

    @GetMapping(path = "/display")
    public @ResponseBody Iterable<House> getAllHouses(){
        return houseRepository.findAll();
    }
}
