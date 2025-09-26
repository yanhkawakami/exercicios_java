package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public OnlinePaymentService getOnlinePaymentService() {
        return onlinePaymentService;
    }

    public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months){
        Double paymentFee;
        Double interest;
        LocalDate date;

        Double valuePerMonth = (double) contract.getTotalValue() / months;

        for (int month = 1; month <= months; month++){
            interest = onlinePaymentService.interest(valuePerMonth, month);
            paymentFee = onlinePaymentService.paymentFee(valuePerMonth + interest);
            date = contract.getDate().plusMonths(month);
            contract.getInstallments().add(new Installment(date, valuePerMonth + paymentFee + interest));
        }
    }
}
