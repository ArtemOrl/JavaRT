package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {

    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    private Controller controller;

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * вызваться при выборе пунктов меню, у которых наше представление указано в виде слушателя событий.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Получи из события команду с помощью метода getActionCommand(). Это будет обычная строка.
        //По этой строке ты можешь понять какой пункт меню создал данное событие.
        String command = e.getActionCommand();

        switch (command) {

            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                showAbout();
                break;
        }
    }


    public void init(){
        initGui();
        addWindowListener(new FrameListener(this));
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void undo(){
        try{
            undoManager.undo();
        } catch (CannotUndoException e){
            ExceptionHandler.log(e);
        }
    }
    public void redo(){
        try{
            undoManager.redo();
        } catch (CannotRedoException e){
            ExceptionHandler.log(e);
        }
    }
    public void exit(){
        controller.exit();
    }

    //инициализаци меню и панелей редактора ()
    public void initMenuBar(){
        JMenuBar bar = new JMenuBar();

        MenuHelper.initFileMenu(this, bar);
        MenuHelper.initEditMenu(this, bar);
        MenuHelper.initStyleMenu(this, bar);
        MenuHelper.initAlignMenu(this, bar);
        MenuHelper.initColorMenu(this, bar);
        MenuHelper.initFontMenu(this, bar);
        MenuHelper.initHelpMenu(this, bar);

        getContentPane().add(bar, BorderLayout.NORTH);
    }

    public View(){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (IllegalAccessException e){}
        catch (InstantiationException e){}
        catch (UnsupportedLookAndFeelException e){}
        catch (ClassNotFoundException e){}
    }

    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.add("HTML", jScrollPane);
        JScrollPane jScrollPane1 = new JScrollPane(plainTextPane);
        tabbedPane.add("Текст", jScrollPane1);
        Dimension dimension = new Dimension(800, 600);
        tabbedPane.setPreferredSize(dimension);
        TabbedPaneChangeListener listener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(listener);
        getContentPane().add(tabbedPane,BorderLayout.CENTER);
    }

    public void selectHtmlTab(){
        //Выбирать html вкладку (переключаться на нее)
        tabbedPane.setSelectedIndex(0);
        //Сбрасывать все правки с помощью метода
        resetUndo();
    }

//    получает документ у контроллера и устанавливать его в панель редактирования htmlTextPane


    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }
    //иниц граф интерфейс
    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }

    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex() == 0;
    }
    public void selectedTabChanged(){
        //Метод должен проверить, какая вкладка сейчас оказалась выбранной
        //Если выбрана вкладка с индексом 0 (html вкладка)
        if (tabbedPane.getSelectedIndex() ==0){
            //if (isHtmlTabSelected()) {
            //значит нам нужно получить текст из plainTextPane и установить его в контроллер с помощью метода setPlainText
            controller.setPlainText(plainTextPane.getText());
        }
        //eсли выбрана вкладка с индексом 1 (вкладка с html текстом)
        else {
            //необходимо получить текст у контроллера с помощью метода getPlainText() и установить его в панель plainTextPane
            plainTextPane.setText(controller.getPlainText());
        }
        //Сбросить правки
        resetUndo();
    }

    public boolean canUndo(){
        return this.undoManager.canUndo();
    }

    public boolean canRedo(){
        return this.undoManager.canRedo();
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void resetUndo(){
        undoManager.discardAllEdits();
    }
    public void showAbout(){
        JOptionPane.showMessageDialog(this, "HTML Editor пиздец я заебался его писать", "About", JOptionPane.INFORMATION_MESSAGE);
    }


}
