package com.beosbank.jbdevg.jbossas.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.event.FlowEvent;

import com.beosbank.jbdevg.jbossas.domain.MoneyTransfert;

@RequestScoped
@ManagedBean(name="mtvcBean")
public class MoneyTransferViewController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Map<String,String> countries;
	private Map<String,String> currencies;
	
	private MoneyTransfert transfert;
	
	public MoneyTransferViewController() {
		
	}
	
	
	@PostConstruct
    public void init() {
        countries  = new HashMap<String, String>();
        countries.put("USA", "USA");
        countries.put("France", "France");
        countries.put("UK", "UK");
        countries.put("Brazil", "Brazil");
        countries.put("Cameroon", "Cameroon");
        countries.put("India", "India");
         
        
        currencies  = new HashMap<String, String>();
        currencies.put("USA", "USD");
        currencies.put("France", "EUR");
        currencies.put("UK", "GBP");
        currencies.put("Brazil", "BRL");
        currencies.put("Cameroon", "XAF");
        currencies.put("India", "INR");
        
        //Load Transfer data from session if any
        getTransfert();
        
	}
	
	
	public void onSenderCountryChanged(){
		String senderCountry=transfert.getSender().getAddress().getCountry();
		String currency= currencies.get(senderCountry);
		if(currency!=null){
			transfert.setSenderCurrencyCode(currency);
		}
		System.out.println("MoneyTransferViewController.onReceipientCountryChanged()" +senderCountry);
		HttpServletRequest request= ( HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	    request.getSession().setAttribute("transfert", transfert);
		
	}
	
	
	public void onReceipientCountryChanged(){
		String destinationCountry=transfert.getReceiver().getAddress().getCountry();
		String currency= currencies.get(destinationCountry);
		if(currency!=null){
			transfert.setReceiverCurrencyCode(currency);
		}
		System.out.println("MoneyTransferViewController.onReceipientCountryChanged()" +destinationCountry);
		HttpServletRequest request= ( HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	    request.getSession().setAttribute("transfert", transfert);
		
	}
	
	
	
	
	
	public String onFlowProcess(FlowEvent event) {
			System.out.println("MoneyTransferViewController.onFlowProcess()");
			System.out.println("MoneyTransferViewController.onFlowProcess() "+transfert);
            return event.getNewStep();
    }
	
	
	public void sendMoney(){
		System.out.println(".sendMoney() ") ;
	}
	
	public MoneyTransfert getTransfert() {
		if(transfert==null){
			HttpServletRequest request= ( HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		    HttpSession session = request.getSession();
		    setTransfert((MoneyTransfert)session.getAttribute("transfert"));
		    if(transfert==null){
		    	setTransfert(new MoneyTransfert());
		    }
		}
		return transfert;
	}
	
	
	public void setTransfert(MoneyTransfert transfert) {
		this.transfert = transfert;
		HttpServletRequest request= ( HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	    HttpSession session = request.getSession();
	    session.setAttribute("transfert",this.transfert);
		System.out.println("MoneyTransferViewController.setTransfert() called with "+transfert +" SessionID="+session.getId());
	}
	
	public Map<String, String> getCountries() {
		return countries;
	}


	public void setCountries(Map<String, String> countries) {
		this.countries = countries;
	}


	public Map<String,String> getCurrencies() {
		return currencies;
	}


	public void setCurrencies(Map<String,String> currencies) {
		this.currencies = currencies;
	}

	
}
