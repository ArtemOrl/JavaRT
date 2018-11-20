package com.javarush.task.task30.task3008.client;

public class ClientGuiController extends Client {



    private ClientGuiModel model = new ClientGuiModel();

    // Создай и проинициализируй поле, отвечающее за представление ClientGuiView view.
    // Подумай, что нужно передать в конструктор при инициализации объекта
    private ClientGuiView view = new ClientGuiView(this);

    public static void main(String[] args) {
        ClientGuiController clientGuiController = new ClientGuiController();
        clientGuiController.run();
    }

    public class GuiSocketThread extends SocketThread{

        @Override
        protected void processIncomingMessage(String message) {
            model.setNewMessage(message);
            view.refreshMessages();
        }

        @Override
        protected void informAboutAddingNewUser(String userName) {
            model.addUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void informAboutDeletingNewUser(String userName) {
            model.deleteUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }

    // должен получать объект SocketThread через метод getSocketThread()и вызывать у него метод run().
    // Разберись, почему нет необходимости вызывать метод run в отдельном потоке, как мы это делали для консольного клиента.
    @Override
    public void run() {
        getSocketThread().run();
    }


    //getters
    @Override
    protected String getServerAddress() {
        return view.getServerAddress();
    }

    @Override
    protected int getServerPort() {
        return view.getServerPort();
    }

    @Override
    protected String getUserName() {
        return view.getUserName();
    }

    public ClientGuiModel getModel() {
        return model;
    }


}
