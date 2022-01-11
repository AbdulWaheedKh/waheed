package org.waheed.java.restController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.waheed.java.businessLayer.manager;
import org.waheed.java.model.account;
import org.waheed.java.utils.AppUtility;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class accountController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private manager managerObj;

    @PostMapping("/createAccount")
    public account createAccount(@RequestBody account acct) throws Exception {
        
        String message = "" ;
        boolean isBadRequest = false;

        if (!AppUtility.isEmpty(acct.getId())) {
            message = "Id must be null";
            isBadRequest = true;
        } else {
            try {
            	acct.setModifiedDate(AppUtility.getCurrentTimeStamp());
            	acct.setCreatedDate(AppUtility.getCurrentTimeStamp());
                acct = managerObj.saveSingleAccount(acct);
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }
        if (isBadRequest) {
			logger.debug(message);
			throw new Exception(message);
		} else {
            logger.info(" Account Saved Successfully ");
			return acct;
		}
    }

}
