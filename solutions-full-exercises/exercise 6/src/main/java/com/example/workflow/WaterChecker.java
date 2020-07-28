package com.example.workflow;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class WaterChecker implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String strawberryStatus = "";
        Integer inchesOfWater = (Integer) delegateExecution.getVariable("inchesOfWater");

        if(inchesOfWater > 2){
            throw new BpmnError("TooMuchWater", "Add Less water or the Strawberries will die!");
        }
        else if(inchesOfWater == 2){
            strawberryStatus = "You've added the right amount of water";
            delegateExecution.setVariable("waterSuccess", true);
        }else{
            strawberryStatus = "it's not looking good for your strawberries";
            delegateExecution.setVariable("waterSuccess", false);
        }

        delegateExecution.setVariable("strawberryStatus", strawberryStatus);
        System.out.println(strawberryStatus);
    }

}
