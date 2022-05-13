package by.javalearning.homework.theme4;

import java.util.List;
import java.util.Objects;

public class ClientList {
    
    private List<Client> clients;

    public ClientList(List<Client> clients) {
	this.clients = clients;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public int hashCode() {
	return Objects.hash(clients);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	ClientList other = (ClientList) obj;
	return Objects.equals(clients, other.clients);
    }
    
    

}
