package DavePackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class HouseController {
    String name;
    long adrew;
    @Autowired
    HouseRepository houseRepository;

  //  HttpServletRequest request=null;
//    HttpSession session = request.getSession();

    @RequestMapping("/")
    public String init(Model model){

        return "newMain";
    }
    @RequestMapping(value = "/home", method = RequestMethod.GET) //@GetRequest
    public String getIt(Model model){
        //System.out.println(name);
        model.addAttribute(new House());
        return  "home";
    }
    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String ProcessHouse(@ModelAttribute House house){
        name = house.getOwnerName();
        adrew = house.getPhone();
        //System.out.println(name);
        house.setDate(new Date());
        houseRepository.save(house);
        return "redirect:/display";
    }
    @RequestMapping(value = "display", method = RequestMethod.GET)
    public String displaySingleEntry(@ModelAttribute House house, Model model){
        //Iterable<House> values = houseRepository.findByOwnerName(name);
        Iterable<House> values = houseRepository.findByPhone(adrew);
        model.addAttribute("values", values);
        return "display";
    }
    @RequestMapping(value = "displayAll", method = RequestMethod.GET)
    public String showAll(Model model){
        Iterable<House> showall = houseRepository.findAll();
        model.addAttribute("showEm",showall);
        return "display";
    }
}
