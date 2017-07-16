package com.beosbank.jbdevg.brms.main;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.drools.core.time.SessionPseudoClock;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.rule.FactHandle;

import com.beosbank.jbdevg.brms.model.MoneyTransfertEvent;

/**
 * This is a sample class to launch a rule.
 */
public class BeosbankMoneyTransfertEventProducer {

    public static final void main(String[] args) {
        try {
        	
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSessionConfiguration config = ks.newKieSessionConfiguration();
        	config.setProperty("drools.eventProcessingMode","stream");
        	config.setProperty( "drools.clockType","pseudo");
        	
        	KieSession session = kContainer.newKieSession("ksession-rules",config);

        	SessionPseudoClock clock = session.getSessionClock();
        	
            // go !
        	System.out.println(clock.getCurrentTime());
            MoneyTransfertEvent mt1 = new MoneyTransfertEvent();
            mt1.setReference("TRX001");
            mt1.setSender("JBoss Doctor");
            mt1.setAmountToSend(800);
            mt1.setCountryFrom("France");
            session.insert(mt1);
            
            //create trx2 after 10hours
            clock.advanceTime( 10, TimeUnit.HOURS);
            MoneyTransfertEvent mt2 = new MoneyTransfertEvent();
            mt2.setReference("TRX002");
            mt2.setSender("JBoss Doctor");
            mt2.setAmountToSend(5000);
            mt2.setCountryFrom("Germany");
            session.insert(mt2);
           
           //create trx3 after 15hours( 25hours from  trx1)
            clock.advanceTime( 15, TimeUnit.HOURS);
            MoneyTransfertEvent mt3 = new MoneyTransfertEvent();
            mt3.setReference("TRX003");
            mt3.setSender("JBoss Doctor");
            mt3.setAmountToSend(10000);
            mt3.setCountryFrom("France");
            session.insert(mt3);
           
            
            session.fireAllRules();
            
            java.util.Collection<FactHandle> factsHandles = session.getFactHandles();
            for (FactHandle factHandle : factsHandles) {
				System.out.println(factHandle);
			}
            
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

   
}
