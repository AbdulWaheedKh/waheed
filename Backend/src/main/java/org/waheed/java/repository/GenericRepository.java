package org.waheed.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;


@NoRepositoryBean
public interface GenericRepository<T extends Object , Serializable> extends JpaRepository<T,Long> {

    @Query("select u from #{#entityName} as u  where u.id = :id and u.Deleted = 0")
	public T getById(@Param("id") Long id);

    @Modifying
    @Query("Update #{#entityName} u set u.Deleted = :isDeleted , modifiedDate = CURRENT_TIMESTAMP where u.id =:id")
	public Integer markAsDeletedById(@Param("id") Long id, @Param("isDeleted") boolean isDeleted);

    @Query("select u from #{#entityName} as u  where u.Deleted = 0")
	public List<T> getAllActiveRecords();

    @Query("select u from #{#entityName} as u")
	public List<T> getAllActiveRecordsNoDeletedColoum();

    
    

}
