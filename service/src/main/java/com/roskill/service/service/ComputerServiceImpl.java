package com.roskill.service.service;


import com.roskill.common.domain.Computer;
import org.springframework.stereotype.Service;

/**
 * Created by likoguan on 3/11/17.
 */
@Service("computerService")
public class ComputerServiceImpl implements ComputerService {
    public Computer getComputer() {
        Computer computer = new Computer();
        computer.setModel("Mac Book Pro 15X");
        return computer;
    }
}
