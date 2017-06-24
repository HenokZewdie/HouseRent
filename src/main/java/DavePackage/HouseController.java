package DavePackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Iterator;


@Controller
public class HouseController {
    String name, adrew;
    @Autowired
    HouseRepository houseRepository;

  //  HttpServletRequest request=null;
//    HttpSession session = request.getSession();


    @RequestMapping(value = "/home", method = RequestMethod.GET) //@GetRequest
    public String getIt(Model model){
        //System.out.println(name);
        model.addAttribute(new House());

        return  "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String ProcessHouse(@ModelAttribute House house){
        name = house.getOwnerName();
        adrew = house.getAddress();
        System.out.println(name);
        houseRepository.save(house);
        return "redirect:/display";
    }

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public String toSend(@ModelAttribute House house, Model model){
        //Iterable<House> values = houseRepository.findByOwnerName(name);
        Iterable<House> values = houseRepository.findByAddress(adrew);
        System.out.println("jsfh");
        model.addAttribute("values", values);

        return "display";
    }
}
