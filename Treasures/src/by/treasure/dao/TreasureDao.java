package by.treasure.dao;

import java.util.List;

import by.treasure.bean.Treasure;

// ������� ������ ��������
// ����� ��������� �� ����
// ����� ��������� �� ��������
// ����� ����� ������� ���������

public interface TreasureDao {
    
    boolean fillTreasureList() throws DAOException;
    List<Treasure> treasures() throws DAOException;
//    List<Treasure> sortByPrice(int price) throws DAOException;
//    List<Treasure> sortByTitle(String title) throws DAOException;
//    Treasure mostPreciousTreasure() throws DAOException;
}
