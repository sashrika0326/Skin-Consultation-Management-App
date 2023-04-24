package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Console.WestminsterSkinConsultationManager.consult;

public class Frame1pop extends GUI_frame implements ActionListener {
    private  JButton ok;

    private String filename;


    Frame1pop(){

        ImageIcon background = new ImageIcon("GUI/consult.jpg");

        JLabel image = new JLabel();
        image.setIcon(background);
        image.setBounds(0,0,500,530);


            JLabel topic = new JLabel();
            topic.setText("YOUR CONSULTATION");
            topic.setBounds(150, 20, 550, 20);
            topic.setForeground(new Color(0x1B1B1C));
            topic.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));


            int loc = (consult.size() - 1);

            JLabel details = new JLabel();
            details.setText("<html><br>" +
                    "01.Name                : " + consult.get(loc).getFirstName() + "<br>" +
                    "02.Surname             : " + consult.get(loc).getSurName() + "<br>" +
                    "03.Date-of-Birth       : " + consult.get(loc).getDateOfBirth() + "<br>" +
                    "04.Mobile-No           : " + consult.get(loc).getContactNumber() + "<br>" +
                    "05.Patient-ID          : " + consult.get(loc).getPatientID() + "<br>" +
                    "06.Consultation-Date   : " + consult.get(loc).getConsultationDate() + "<br>" +
                    "07.Start-Time          : " + consult.get(loc).getConsultationStartTime() + "<br>" +
                    "08.End-Time            : " + consult.get(loc).getConsultationEndTime() + "<br>" +
                    "09.Consulted-Doctor    : " + consult.get(loc).getConsultationID() + "<br>" +
                    "10.Cost-for-Consulation: " + consult.get(loc).getCost() + "<br></html>");

            details.setBounds(39, 10, 400, 400);
            details.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 15));


            this.add(topic);
            this.add(details);


        button();
        this.add(image);
        window("message_box",500,530);
    }


    public void button_set(JButton but,String name) {
        but.setBounds(210,420,70,30);
        but.setText(name);
        but.setFocusable(false);
        but.addActionListener(this);
        this.add(but);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()== ok) {

                this.dispose();
                new GUI();
            }

    }
    @Override
    public void button() {

        ok = new JButton();
        button_set(ok,"OK");

    }

}
