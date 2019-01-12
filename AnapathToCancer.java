package projet.ime202;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnapathToCancer {
	
	
		
	public Cancer Cim10toCancer( String DP,String DR,String DAS ) {
        // connecter la base de données
        Connection conn = null;
        ResultSet rs1 = null;
        PreparedStatement ptmt1 = null;
        ResultSet rs2 = null;
        PreparedStatement ptmt2 = null;
        ResultSet rs3 = null;
        PreparedStatement ptmt3 = null;
        ResultSet rs4 = null;
        PreparedStatement ptmt4 = null;
        ResultSet rs5 = null;
        PreparedStatement ptmt5 = null;
        ResultSet rs6 = null;
        PreparedStatement ptmt6 = null;
        ResultSet rs7 = null;
        PreparedStatement ptmt7 = null;
        ResultSet rs8 = null;
        PreparedStatement ptmt8 = null;
        ResultSet rs9 = null;
        PreparedStatement ptmt9 = null;

        Cancer  cancer = new Cancer();
        try
        {
            conn = DBConnection.getConnection();
            // manipulation de la base de données
            ptmt1= conn.prepareStatement("{call CIM10_DP(?)}");
            ptmt1.setString(1, DP);
            rs1=ptmt1.executeQuery();
            while (rs1.next()) {
            	//un groupe de to et mo
                //System.out.println("CODMORPHOCIMO3"+" "+rs1.getString("CODMORPHOCIMO3"));
                String DP_CODMORPHOCIMO3=rs1.getString("CODMORPHOCIMO3");
                //System.out.println("CODTOPOCIMO3"+" "+rs1.getString("CODTOPOCIMO3"));    
                String DP_CODTOPOCIMO3=rs1.getString("CODTOPOCIMO3");
                
                ptmt2= conn.prepareStatement("{call CIM10_DP1(?)}");
                ptmt2.setString(1,DP_CODTOPOCIMO3);
                rs2=ptmt2.executeQuery();
                while(rs2.next()) {
                	System.out.println("DP:"+DP);
                	cancer.setCimo_to(DP_CODTOPOCIMO3);
                    System.out.println("CODTOPOCIMO3"+" "+DP_CODTOPOCIMO3+" "+"GROUPE_TOPO_IACR"+" "+rs2.getString("GROUPE_TOPO_IACR"));
                    cancer.setIacr_to(rs2.getString("GROUPE_TOPO_IACR"));
                    
                    
                    ptmt3= conn.prepareStatement("{call CIM10_DP2(?)}");
                    ptmt3.setString(1,DP_CODMORPHOCIMO3);
                    rs3=ptmt3.executeQuery();
                    while(rs3.next()) {
                    	
                        cancer.setCimo_mo(DP_CODMORPHOCIMO3);
                        System.out.println("CODTOPOCIMO3"+" "+DP_CODMORPHOCIMO3+" "+"GROUPE_MORPHO_IACR"+" "+rs3.getString("GROUPE_MORPHO_IACR"));
                        cancer.setIacr_mo(rs3.getString("GROUPE_MORPHO_IACR"));
                        System.out.println("---------------------------------------------------");
                      
                    }
                    }
               
             }
            //DR
            
            ptmt4= conn.prepareStatement("{call CIM10_DR(?)}");
            ptmt4.setString(1, DR);
            rs4=ptmt4.executeQuery();
            if(DR=="") {
            	System.out.println("y a pas de DR POUR ce groupe diagnostic ");
            	System.out.println("---------------------------------------------------");
            }else {
            while (rs4.next()) {
                //System.out.println("CODMORPHOCIMO3"+" "+rs4.getString("CODMORPHOCIMO3"));
                String DR_CODMORPHOCIMO3=rs4.getString("CODMORPHOCIMO3");
                //System.out.println("CODTOPOCIMO3"+" "+rs4.getString("CODTOPOCIMO3"));    
                String DR_CODTOPOCIMO3=rs4.getString("CODTOPOCIMO3");
                
                ptmt5= conn.prepareStatement("{call CIM10_DR1(?)}");
                ptmt5.setString(1,DR_CODTOPOCIMO3);
                rs5=ptmt5.executeQuery();
                while(rs5.next()) {
                	System.out.println("DR:"+"");
                	cancer.setCimo_to(DR_CODTOPOCIMO3);
                    System.out.println("CODTOPOCIMO3"+" "+DR_CODTOPOCIMO3+" "+"GROUPE_TOPO_IACR"+" "+rs5.getString("GROUPE_TOPO_IACR"));
                    cancer.setIacr_to(rs5.getString("GROUPE_TOPO_IACR"));
                    
                    
                    ptmt6= conn.prepareStatement("{call CIM10_DP2(?)}");
                    ptmt6.setString(1,DR_CODMORPHOCIMO3);
                    rs6=ptmt6.executeQuery();
                    while(rs6.next()) {
                    	
                        cancer.setCimo_mo(DR_CODMORPHOCIMO3);
                        System.out.println("CODMORPHOCIMO3"+" "+DR_CODMORPHOCIMO3+" "+"GROUPE_MORPHO_IACR"+" "+rs6.getString("GROUPE_MORPHO_IACR"));
                        cancer.setIacr_mo(rs6.getString("GROUPE_MORPHO_IACR"));
                        System.out.println("---------------------------------------------------");
                    }
                    }
               
             }
            }
            //DAS
            ptmt7= conn.prepareStatement("{call CIM10_DAS(?)}");
            ptmt7.setString(1, DAS);
            rs7=ptmt7.executeQuery();
            while (rs7.next()) {
                //System.out.println("CODMORPHOCIMO3"+" "+rs7.getString("CODMORPHOCIMO3"));
                String DAS_CODMORPHOCIMO3=rs7.getString("CODMORPHOCIMO3");
                //System.out.println("CODTOPOCIMO3"+" "+rs7.getString("CODTOPOCIMO3"));    
                String DAS_CODTOPOCIMO3=rs7.getString("CODTOPOCIMO3");
                
                ptmt8= conn.prepareStatement("{call CIM10_DAS1(?)}");
                ptmt8.setString(1,DAS_CODTOPOCIMO3);
                rs8=ptmt8.executeQuery();
                while(rs8.next()) {
                	System.out.println("DAS:"+DAS);
                	cancer.setCimo_to(DAS_CODTOPOCIMO3);
                    System.out.println("CODTOPOCIMO3"+" "+DAS_CODTOPOCIMO3+" "+"GROUPE_TOPO_IACR"+" "+rs8.getString("GROUPE_TOPO_IACR"));
                    cancer.setIacr_to(rs8.getString("GROUPE_TOPO_IACR"));
                    
                    
                    ptmt9= conn.prepareStatement("{call CIM10_DAS2(?)}");
                    ptmt9.setString(1,DAS_CODMORPHOCIMO3);
                    rs9=ptmt9.executeQuery();
                    while(rs9.next()) {
                    	
                        cancer.setCimo_mo(DAS_CODMORPHOCIMO3);
                        System.out.println("CODMORPHOCIMO3"+" "+DAS_CODMORPHOCIMO3+" "+"GROUPE_MORPHO_IACR"+" "+rs9.getString("GROUPE_MORPHO_IACR"));
                        cancer.setIacr_mo(rs9.getString("GROUPE_MORPHO_IACR"));
                        System.out.println("---------------------------------------------------");
                    }
                    }
                
             }
    
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {

            try
            {
                if (rs1 != null)
                {
                    rs1.close();
                }
                if (ptmt1 != null)
                {
                    ptmt1.close();
                }
           }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
		return cancer;

    }
    
	
	
	
	
	public Cancer AdicaptoCancer( String lesion_patient, String organe_patient) {
        // connecter la base de données
        Connection conn = null;
        ResultSet rs1 = null;
        PreparedStatement ptmt1 = null;
        ResultSet rs2 = null;
        PreparedStatement ptmt2 = null;
        ResultSet rs3 = null;
        PreparedStatement ptmt3 = null;
        ResultSet rs4 = null;
        PreparedStatement ptmt4 = null;
        Cancer  cancer = new Cancer();
        try
        {
            conn = DBConnection.getConnection();
            // manipulation de la base de données            StringBuilder sb1 = new StringBuilder();            //sb1.append("SELECT ADICAP_LESION,TRANSCODAGE_ADICAPCIMO3_MORPHO.CODMORPHOCIMO3 FROM anapath inner join TRANSCODAGE_ADICAPCIMO3_MORPHO on TRANSCODAGE_ADICAPCIMO3_MORPHO.LESION='lesion_patient'");
            ptmt1= conn.prepareStatement("{call lesion(?)}");
            ptmt1.setString(1, lesion_patient);
            rs1=ptmt1.executeQuery();
            while (rs1.next()) {
            	System.out.println("lesion:"+lesion_patient);
                //System.out.println("CODMORPHOCIMO3"+" "+rs1.getString("CODMORPHOCIMO3"));
                String MOR_CODMORPHOCIMO3=rs1.getString("CODMORPHOCIMO3");  
                ptmt2= conn.prepareStatement("{call lesion2(?)}");
                ptmt2.setString(1, MOR_CODMORPHOCIMO3);
                rs2=ptmt2.executeQuery();
                while(rs2.next()) {
                cancer.setCimo_mo(MOR_CODMORPHOCIMO3);
                System.out.println("CODMORPHOCIMO3"+" "+MOR_CODMORPHOCIMO3+" "+"GROUPE_MORPHO_IACR"+" "+rs2.getString("GROUPE_MORPHO_IACR"));
                cancer.setIacr_mo(rs2.getString("GROUPE_MORPHO_IACR"));
                }
             }

            ptmt3= conn.prepareStatement("{call organe(?)}");
            ptmt3.setString(1, organe_patient);
            rs3=ptmt3.executeQuery();
            while(rs3.next()) {
            //System.out.println("CODTOPOCIMO3"+" "+rs3.getString("CODTOPOCIMO3"));
        
            String TOPO_CODTOPOCIMO3=rs3.getString("CODTOPOCIMO3");
          
            ptmt4= conn.prepareStatement("{call organe2(?)}");
            ptmt4.setString(1,TOPO_CODTOPOCIMO3);
            rs4=ptmt4.executeQuery();
            while(rs4.next()) {
            System.out.println("organe:"+organe_patient);
            cancer.setCimo_to(TOPO_CODTOPOCIMO3);
            System.out.println("CODTOPOCIMO3"+" "+TOPO_CODTOPOCIMO3+" "+"GROUPE_TOPO_IACR"+" "+rs4.getString("GROUPE_TOPO_IACR"));
            cancer.setIacr_to(rs4.getString("GROUPE_TOPO_IACR"));
            }

        }
    
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {

            try
            {
                if (rs1 != null)
                {
                    rs1.close();
                }
                if (ptmt1 != null)
                {
                    ptmt1.close();
                }
           }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
		return cancer;

    }
		
		
		
	}
	

