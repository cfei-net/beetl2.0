package org.beetl.core.resource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import org.beetl.core.Resource;
import org.beetl.core.ResourceLoader;
import org.beetl.core.exception.BeetlException;

public class ClasspathResource extends Resource
{
	String path = null;

	public ClasspathResource(String key, String path, ResourceLoader loader)
	{
		super(key, loader);
		this.path = path;
	}

	@Override
	public Reader openReader()
	{
		InputStream is = ClasspathResource.class.getResourceAsStream(path);
		if (is == null)
		{
			BeetlException be = new BeetlException(BeetlException.TEMPLATE_LOAD_ERROR, "classpath resource not found:"
					+ id);
			throw be;
		}
		Reader br;
		try
		{
			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			return br;
		}
		catch (UnsupportedEncodingException e)
		{
			return null;
		}
	}

	@Override
	public boolean isModified()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getId()
	{
		return id;
	}

}
