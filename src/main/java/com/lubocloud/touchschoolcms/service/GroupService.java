package com.lubocloud.touchschoolcms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubocloud.touchschoolcms.dao.GroupDao;
import com.lubocloud.touchschoolcms.entity.Group;

@Service("groupService")
@Transactional
public class GroupService {

	@Autowired
	private GroupDao groupDao;
    
	public GroupService()
	{
	}
	
	public void addGroup(Group g)
	{
		groupDao.save(g);
	}
	
	public void delGroup(int id)
	{
		groupDao.delete(id);
	}
	
	public void editGroup(Group g)
	{
		groupDao.update(g);
	}
	
	public Group findGroup(int id)
	{
		return groupDao.findById(id);
	}
	
	public List<Group> listAllGroup()
	{
		return groupDao.listAll();
	}
	
	public List<Group> listDirectChildrenGroup(int id)
	{
		if(id<=0){
			return groupDao.findByColumn("parentGroup", null);
		}else{
			return groupDao.findByColumn("parentGroup.gid", id);
		}
	}

	public String getAllChildrenGroupWithJson(int groupId)
	{
        String jsonStr = null;
        if(groupId>0){
        	Group parentGroup = groupDao.findById(groupId);
            if(parentGroup==null){
            	return null;
            }
            jsonStr = "{\"name\":\""+parentGroup.getName()+"\", \"id\":"+parentGroup.getGid();
        }else{
	        jsonStr = "{\"name\":\"在线学习平台\", \"id\":0";
        }
        List<Group> grouplist = groupDao.listAll();
        if(grouplist!=null && grouplist.size()>0){
        	String childStr = recursionGroup(grouplist, groupId);
        	if(childStr!=null)
        	{
        		jsonStr += childStr;
        	}
        }
        jsonStr += "}";
		return jsonStr;
	}
	
	private String recursionGroup(List<Group> grouplist, int parentId)
	{
		String jsonStr = null;
		List<Group> childGroupList = new ArrayList<Group>();
    	for(int i=0; i<grouplist.size(); i++)
    	{
    		Group childGroup = grouplist.get(i);
    		if( (parentId<=0&&childGroup.getParentGroup()==null) || 
    				(childGroup.getParentGroup()!=null&&parentId==childGroup.getParentGroup().getGid()) )
    		{
    			childGroupList.add(childGroup);
    		}
    	}
		if(childGroupList.size()>0)
		{
			jsonStr = ", \"children\":[";
			for(int i=0; i<childGroupList.size(); i++)
			{
				Group childGroup = childGroupList.get(i);
	    		jsonStr += "{\"name\":\""+childGroup.getName()+"\",\"id\":"+childGroup.getGid();
	    		String childStr = recursionGroup(grouplist, childGroup.getGid());
	    		if(childStr!=null){
	    			jsonStr += childStr;
	    		}
	    		if(i==childGroupList.size()-1){
	    			jsonStr += "}";
	    		}else{
	    			jsonStr += "},";
	    		}
			}
	    	jsonStr += "]";
		}
		return jsonStr;
	}

	public String listDirectChildrenGroupWithJson(int id)
	{
		String jsonStr = null;
		List<Group> grouplist = null;
		
		if(id>0){
			Group group = groupDao.findById(id);
			if(group!=null)
			{
				jsonStr = "{\"name\": \""+group.getName()+"\", \"id\": "+group.getGid();
				grouplist = groupDao.findByColumn("parentGroup.gid", id);
			}else{
				return null;
			}
		}else{
			jsonStr = "{\"name\": \"在线学习平台\", \"id\": 0";
			grouplist = groupDao.findByColumn("parentGroup", null);
		}
		if(grouplist!=null && grouplist.size()>0){
        	jsonStr += ", \"children\":[";
        	for(int i=0; i<grouplist.size(); i++){
        		Group childgroup = grouplist.get(i);
        		jsonStr += "{\"name\":\""+childgroup.getName()+"\",\"id\":"+childgroup.getGid();
        		if(i==grouplist.size()-1){
        			jsonStr += "}";
        		}else{
        			jsonStr += "},";
        		}
        	}
			jsonStr += "]";
        }
		jsonStr += "}";
		return jsonStr;
	}
	
}
