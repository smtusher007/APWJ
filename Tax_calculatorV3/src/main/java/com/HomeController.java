package com;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
//import javax.xml.transform.Result;


@Controller
public class HomeController {

    private DataSource dataSource;

    public HomeController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @RequestMapping("/registration")
    public String calc(HttpServletRequest request, HttpServletResponse response){
        return "registration";
    }

    @RequestMapping("/calculatedTax")
    public String cal (@ModelAttribute("Basic_salary") int Basic_salary, @ModelAttribute("House_rent") int House_rent, @ModelAttribute("Medical_allowance") int Medical_allowance,
                       @ModelAttribute("Conveyance") int Conveyance,@ModelAttribute("Incentive") int Incentive,@ModelAttribute("Festival_Bonus") int Festival_Bonus, Model model)  {

        model.addAttribute("Basic_salary",Basic_salary);
        model.addAttribute("House_rent", House_rent);

        model.addAttribute("Medical_allowance", Medical_allowance);
        model.addAttribute("Conveyance", Conveyance);
        model.addAttribute("Incentive", Incentive);
        model.addAttribute("Festival_Bonus", Festival_Bonus);
        int sum = 0;
        int HouseRentExemption= Basic_salary*50/100;
        int taxableHouseRent = House_rent - HouseRentExemption;
        if(HouseRentExemption>House_rent) {

            taxableHouseRent=0;
        }

        int MedicalAllowanceExemption= Basic_salary*10/100;
        int taxableMedicalAllowance =Medical_allowance-MedicalAllowanceExemption;
        if(MedicalAllowanceExemption>Medical_allowance){

            taxableMedicalAllowance=0;
        }

        int ConveyanceExemption = 30000;
        int taxableConveyance=Conveyance-ConveyanceExemption;

if(Conveyance<30000){

    taxableConveyance=0;
}
        sum =  Basic_salary +taxableHouseRent+taxableMedicalAllowance+taxableConveyance+ Incentive+Festival_Bonus;

        model.addAttribute("sum", sum);
        model.addAttribute("HouseRentExemption", HouseRentExemption);
        model.addAttribute("taxableHouseRent", taxableHouseRent);
        model.addAttribute("MedicalAllowanceExemption", MedicalAllowanceExemption);
        model.addAttribute("taxableMedicalAllowance", taxableMedicalAllowance);
        model.addAttribute(" ConveyanceExemption", ConveyanceExemption);
        model.addAttribute("taxableConveyance", taxableConveyance);


        int checkpoint1=0;
        int checkpoint2=0;
        int checkpoint3=0;
        int checkpoint4=0;
        int checkpoint5=0;
        int remaining=sum;
        int newTotal=0;
        int payableTax=0;
        if(remaining>300000){
            remaining =remaining-300000;
            payableTax=payableTax+0;
            newTotal=newTotal+300000;
        }
        if(remaining>100000){
            remaining =remaining-100000;
            payableTax=payableTax+5000;
            checkpoint1=payableTax;
            newTotal=newTotal+100000;
        }
        if(remaining>300000){
            remaining=remaining-300000;
            payableTax=payableTax+30000;
            checkpoint2=payableTax;
            newTotal= newTotal+300000;
        }
        if(remaining>400000){
            remaining=remaining-400000;
            payableTax=payableTax+60000;
            checkpoint3=payableTax;
            newTotal=newTotal+400000;
        }
        if(remaining>500000){
            remaining=remaining-500000;
            payableTax=payableTax+100000;
            checkpoint4=payableTax;
            newTotal=newTotal+500000;
        }
        if(remaining>0){
            remaining=sum-newTotal;
            payableTax=payableTax+(remaining*25/100);
            checkpoint5=payableTax;
        }



        model.addAttribute("payableTax", payableTax);
        model.addAttribute("checkpoint1", checkpoint1);
        model.addAttribute("checkpoint2", checkpoint2);
        model.addAttribute("checkpoint3", checkpoint3);
        model.addAttribute("checkpoint4", checkpoint4);
        model.addAttribute("checkpoint5", checkpoint5);





        return "CalculatedTax";
    }






}
