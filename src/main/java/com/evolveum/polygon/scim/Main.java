package com.evolveum.polygon.scim;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.filefilter.NotFileFilter;
import org.identityconnectors.common.CollectionUtil;
import org.identityconnectors.common.logging.Log;
import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.AttributeBuilder;
import org.identityconnectors.framework.common.objects.AttributeUtil;
import org.identityconnectors.framework.common.objects.ConnectorObject;
import org.identityconnectors.framework.common.objects.Name;
import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.ResultsHandler;
import org.identityconnectors.framework.common.objects.Uid;
import org.identityconnectors.framework.common.objects.filter.AndFilter;
import org.identityconnectors.framework.common.objects.filter.AttributeFilter;
import org.identityconnectors.framework.common.objects.filter.ContainsFilter;
import org.identityconnectors.framework.common.objects.filter.EndsWithFilter;
import org.identityconnectors.framework.common.objects.filter.EqualsFilter;
import org.identityconnectors.framework.common.objects.filter.Filter;
import org.identityconnectors.framework.common.objects.filter.FilterBuilder;
import org.identityconnectors.framework.common.objects.filter.NotFilter;
import org.identityconnectors.framework.common.objects.filter.OrFilter;
import org.identityconnectors.framework.common.objects.filter.StartsWithFilter;

//import com.evolveum.polygon.test.slsfrc.JsonDataProvider;
 
public class Main {

	public static final Uid TEST_UID = new Uid("00558000000W2vRAAS");
	public static final ArrayList<ConnectorObject> result = new ArrayList<>();
	
	private static final Log LOGGER = Log.getLog(Main.class);
	
    public static void main(String[] args) {
    	
    	
    	
    	ObjectClass userC = ObjectClass.ACCOUNT;
    	ObjectClass groupC = ObjectClass.GROUP;
    	
    	Uid newObject = null;
     	
    	EqualsFilter aeq = (EqualsFilter)FilterBuilder.equalTo(TEST_UID);
    	
    /*TODO set for emails*/	EqualsFilter eq = (EqualsFilter)FilterBuilder.equalTo(AttributeBuilder.build("emails.work.value","someone@hometest554xz.com"));
    	
    	ContainsFilter con = (ContainsFilter)FilterBuilder.contains(AttributeBuilder.build("userName","harryp0234"));
    	
    	ContainsFilter ct = (ContainsFilter)FilterBuilder.contains(AttributeBuilder.build("userName","aeoinoaiedoiaedionasinad"));
    	
    
    	
    	OrFilter orf = (OrFilter) FilterBuilder.or(eq, ct);
    	
    	AndFilter andf = (AndFilter) FilterBuilder.and(con, con);
    	
    	NotFilter not= (NotFilter)FilterBuilder.not(eq);
    
    	
    	//System.out.println(eq.);
    	
    	Attribute attribute = ((EqualsFilter) eq).getAttribute();
    	
    	String s = AttributeUtil.getStringValue(attribute);
    	
    	
    	ScimConnectorConfiguration conf= new ScimConnectorConfiguration();
    	ScimConnector conn = new ScimConnector();
    	conn.init(conf);

    	newObject = conn.create(userC, classicBuilderTestUser(), null);

    	//conn.executeQuery(groupC, null, handler, null);
    	//conn.update(userC, TEST_UID,classicBuilderTestUser(), null);
    	//conn.delete(userC, TEST_UID, null);
    	//conn.schema();
    	
    	LOGGER.info("Handler result: {0}", result); // Result handler 
    }
    
    private static Set<Attribute> GenericBuilderTest(){
    	
    	// Setting up attribute
    	Set<Attribute> attr = new HashSet<Attribute>();
        
    	// Map for Maultivalue attribute name
    	
    	Map<String,Map<String, Object>> nameMap = new HashMap<String,Map<String,Object>>();
    	Map<String, Object> names = new HashMap<String, Object>();
    	
    	// Map for Maultivalue attribute schema extension
    	
    	Map<String,Map<String, Object>> extensionMap = new HashMap<String,Map<String,Object>>();
    	Map<String, Object> extensionAtributes = new HashMap<String, Object>();
    	
    	
    	// Map for multilayered attribute Email
        Map<String, Collection<Map<String, Object>>> emailMap = new HashMap<String, Collection<Map<String, Object>>>();
        Map<String, Object> emailAttribute1 = new HashMap<String, Object>();
        Map<String, Object> emailAttribute2 = new HashMap<String, Object>();
        
        // Map for multilayered attribute phoneNumbers
        Map<String, Collection<Map<String, Object>>> phoneMap = new HashMap<String, Collection<Map<String, Object>>>();
        Map<String, Object> phoneAttribute1 = new HashMap<String, Object>();
        Map<String, Object> phoneAttribute2 = new HashMap<String, Object>();
        
     // Map for multilayered attribute entitlements
        Map<String, Collection<Map<String, Object>>> entitlementMap = new HashMap<String, Collection<Map<String, Object>>>();
        Map<String, Object> entitlementAttribute1 = new HashMap<String, Object>();
        Map<String, Object> entitlementAttribute2 = new HashMap<String, Object>();
        
        //Name
        names.put("formatted", "Harry Potter");
        names.put("familyName", "Potter");
        names.put("givenName", "Harry");
        
        nameMap.put("name", names);
        
        //extension ########## Enterprise extension
        extensionAtributes.put("organization", "00D58000000YfgfEAC");
        
        extensionMap.put("urn:scim:schemas:extension:enterprise:1.0", extensionAtributes);
        
        // Email 
        emailMap.put("emails", new ArrayList<Map<String,Object>>());
        emailMap.get("emails").add(emailAttribute1);
       
        
        emailAttribute1.put("type", "home");
        
        emailAttribute1.put ("value","someone@hometest554xz.com");
        
        emailAttribute2.put ("primary",true);
        
        emailAttribute2.put("type", "work");
        
        emailAttribute2.put("value","someone@hometest554xz.com");
        
        
        //Entitlements
        
        entitlementMap.put("entitlements", new ArrayList<Map<String,Object>>());
        entitlementMap.get("entitlements").add(entitlementAttribute1);
        
        entitlementAttribute1.put("display", "Custom: Support Profile");
        
        entitlementAttribute1.put ("value","00e58000000qvhqAAA");
        
        entitlementAttribute1.put("primary", true);
        
        
        //Phone
        
        phoneMap.put("phoneNumbers", new ArrayList<Map<String,Object>>());
        phoneMap.get("phoneNumbers").add(phoneAttribute1);
        phoneMap.get("phoneNumbers").add(phoneAttribute2);
        
        phoneAttribute1.put("type", "mobile");
        
        phoneAttribute1.put ("value","+421 910039218");
        
        phoneAttribute2.put("type", "work");
        
        phoneAttribute2.put("value","+421 915039218");
        
        
        // Attribute 
        attr.add(AttributeBuilder.build("layeredAttrribute", emailMap));
        attr.add(AttributeBuilder.build("layeredAttrribute", phoneMap));
        attr.add(AttributeBuilder.build("layeredAttrribute", entitlementMap));
        attr.add(AttributeBuilder.build("multiValueAttrribute", nameMap));
        attr.add(AttributeBuilder.build("multiValueAttrribute",extensionMap));
        attr.add(AttributeBuilder.build("nickName", "HP"));
        attr.add(AttributeBuilder.build("userName", "harryp0234@hogwarts.com"));
        
        return attr;
    }
    
    private static Set<Attribute> classicBuilderTestUser(){
    	

    	
       	Set<Attribute> attr = new HashSet<Attribute>();
       	
       		
       	   attr.add(AttributeBuilder.build("userName", "newTest3@eastcubattor1.com"));
 
           
           attr.add(AttributeBuilder.build("nickName", "TestUserThree"));
           
           attr.add(AttributeBuilder.build("emails.work.value", "newTest3@eastcubattor1.com"));  
           attr.add(AttributeBuilder.build("emails.work.primary", true));
          // attr.add(AttributeBuilder.build("emails.home.value", "teeawsst@eastcubattor1.com"));
           
           attr.add(AttributeBuilder.build("name.formatted","TestThree Johnsson"));
           attr.add(AttributeBuilder.build("name.familyName","Johnsson"));
           attr.add(AttributeBuilder.build("name.givenName","TestThree"));
           
           
     //      attr.add(AttributeBuilder.build("groups.value","aaa"));
         //  attr.add(AttributeBuilder.build("groups.display","bbb"));
         /* 
           attr.add(AttributeBuilder.build("addresses.home.locality", "snina"));
           attr.add(AttributeBuilder.build("addresses.home.region", "Presov"));
           attr.add(AttributeBuilder.build("addresses.home.postalCode", "06901"));
           attr.add(AttributeBuilder.build("addresses.home.country", "SR"));
         */   

           attr.add(AttributeBuilder.build("entitlements..value", "00e58000000qvhqAAA"));
           
           //attr.add(AttributeBuilder.build("schemaExtension.type", "urn:scim:schemas:extension:enterprise:1.0"));  
          // attr.add(AttributeBuilder.build("schemaExtension.organization", "00D58000000YfgfEAC")); 
           
      //    attr.add(AttributeBuilder.build("schema.organiazation", "TestOrg"));
           
       	
       	attr.add(AttributeBuilder.build("addresses.home.locality", "snina"));
         attr.add(AttributeBuilder.build("addresses.home.region", "Presov"));
        attr.add(AttributeBuilder.build("addresses.home.postalCode", "06901"));
         attr.add(AttributeBuilder.build("addresses.home.country", "SR"));
    	return attr;
    }
    
    
private static Set<Attribute> classicBuilderTestGroup(){
    	

    	
       	Set<Attribute> attr = new HashSet<Attribute>();
       	
       		
       	   attr.add(AttributeBuilder.build("displayName", "newTest3@eastcubattor1.com"));
       //	 attr.add(AttributeBuilder.build("members..value", "teest@eastcubattor1.com"));
       	// attr.add(AttributeBuilder.build("members..display", "teest@eastcubattor1.com"));
       	 
       //	 attr.add(AttributeBuilder.build("members..value", "teest@eastcubattor1.com"));
       //   attr.add(AttributeBuilder.build("members..display", "teest@eastcubattor1.com"));
    	return attr;
    }
    
    static ResultsHandler handler= new ResultsHandler() {
		
		@Override
		public boolean handle(ConnectorObject connectorObject) {
			result.add(connectorObject);
			return true;
		}
	};
	
	
    
    }

