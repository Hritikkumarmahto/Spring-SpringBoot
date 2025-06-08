/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


public class TablePrinter extends TagSupport {
    public int number;

    public void setNumber(int number) {
        this.number = number;
    }
    

    @Override
    public int doStartTag() throws JspException {
        
        try{
            
            JspWriter out=pageContext.getOut();
            for(int i=0;i<=10;i++){
                out.println(number*i);
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    return SKIP_BODY;
    }
    
   
}
