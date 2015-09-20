/**
 *	2015年9月19日 下午5:56:45
 *	tangli
 */
package cache;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.CacheManagerBuilder;
import org.ehcache.PersistentCacheManager;
import org.ehcache.UserManagedCache;
import org.ehcache.UserManagedCacheBuilder;
import org.ehcache.config.CacheConfigurationBuilder;
import org.ehcache.config.ResourcePoolsBuilder;
import org.ehcache.config.event.CacheEventListenerConfigurationBuilder;
import org.ehcache.config.persistence.CacheManagerPersistenceConfiguration;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.config.xml.XmlConfiguration;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.ehcache.event.EventType;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;

/**
 * @author tangli 2015年9月19日下午5:56:45
 */
public class EhCache
{

	public static void main(String[] ar) throws Exception
	{

		// test1();

		// testXml();

		//testUserCache();
		
//		testCache();
		
//		testListenner();
		
		
//		testOffHeap();
		
		PersistentCacheManager persistentCacheManager = CacheManagerBuilder.newCacheManagerBuilder()
			    .with(new CacheManagerPersistenceConfiguration(new File("c:/", "tanglidata"))) 
			    .withCache("persistent-cache", CacheConfigurationBuilder.newCacheConfigurationBuilder()
			        .withResourcePools(ResourcePoolsBuilder.newResourcePoolsBuilder()
			            .heap(10000, EntryUnit.ENTRIES)
			            .disk(2, MemoryUnit.GB, true)).withExpiry(Expirations.timeToLiveExpiration(new Duration(60,java.util.concurrent.TimeUnit.SECONDS))) 
			        .buildConfig(Long.class, String.class))
			    .build(true);

		Cache<Long, String> cache = persistentCacheManager.getCache("persistent-cache", Long.class, String.class);
		for (int i = 0; i < 100000; i++)
		{
			cache.put(new Long(i), "tangli's data" + i);
		}

		System.out.println(cache.get(0L));


		try
		{
			while(true)
			{
				BufferedReader strin=new BufferedReader(new InputStreamReader(System.in));
				System.out.println("输入数字key！");
				String str = strin.readLine(); 
				System.out.println(cache.get(new Long(str)));
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			persistentCacheManager.close();
			
		}
		
	}

	/**
	 * 
	 */
	public static void testOffHeap()
	{
		CacheManager cacheManager = CacheManagerBuilder
				.newCacheManagerBuilder()
				.withCache("tieredCache",CacheConfigurationBuilder.newCacheConfigurationBuilder()
				.withResourcePools(ResourcePoolsBuilder.newResourcePoolsBuilder().heap(10, EntryUnit.ENTRIES).offheap(110, MemoryUnit.MB))
				.buildConfig(Long.class, String.class)).build(true);

		Cache<Long, String> cache = cacheManager.getCache("tieredCache", Long.class, String.class);
		for (int i = 0; i < 1000000; i++)
		{
			cache.put(new Long(i), "tangli's data" + i);
		}

		System.out.println(cache.get(0L));
		
		
		cacheManager.close();
	}

	/**
	 * 
	 */
	private static void testListenner()
	{
		CacheEventListenerConfigurationBuilder cacheEventListenerConfiguration = CacheEventListenerConfigurationBuilder
				.newEventListenerConfiguration(MyEventLis.class, EventType.CREATED, EventType.UPDATED).unordered().asynchronous();

		final CacheManager manager = CacheManagerBuilder.newCacheManagerBuilder()
				.withCache("foo", CacheConfigurationBuilder.newCacheConfigurationBuilder().add(cacheEventListenerConfiguration).buildConfig(String.class, String.class))
				.build(true);

		final Cache<String, String> cache = manager.getCache("foo", String.class, String.class);
		cache.put("Hello", "World");
		cache.put("Hello", "Everyone");
		cache.remove("Hello");
	}
	
	public static class MyEventLis implements CacheEventListener<String,String>
	{

		@Override
		public void onEvent(CacheEvent<String, String> event)
		{
			
			System.out.println("be alert..." + event.toString());
			
		}
	}

	
	
	
	/**
	 * 
	 */
	private static void testThreeCache()
	{
		PersistentCacheManager persistentCacheManager = CacheManagerBuilder
				.newCacheManagerBuilder()
				.with(new CacheManagerPersistenceConfiguration(new File("c:/", "tanglidata")))
				.withCache("threeTieredCache",CacheConfigurationBuilder.newCacheConfigurationBuilder()
				.withResourcePools(ResourcePoolsBuilder.newResourcePoolsBuilder()
						.heap(10000, EntryUnit.ENTRIES)
						.offheap(159, MemoryUnit.MB)
						.disk(2, MemoryUnit.GB))
				.buildConfig(Long.class, String.class)).build(true);

		Cache<Long, String> cache = persistentCacheManager.getCache("threeTieredCache",Long.class, String.class);
		for(int i = 0 ;i <100000;i++)
		{
			cache.put(new Long(i), "tangli's data" + i);
		}
		
		System.out.println(cache.get(1990L));
		
		persistentCacheManager.close();
	}

	/**
	 * 
	 */
	private static void testUserCache()
	{
		UserManagedCache<Long, String> userManagedCache = UserManagedCacheBuilder.newUserManagedCacheBuilder(Long.class,
				String.class).build(false);
		userManagedCache.init();//if build is true ,it is not needed

		userManagedCache.put(1L, "da one!");
		
		System.out.println(userManagedCache.get(1L));

		userManagedCache.close();
	}

	/**
	 */
	public static void testXml() throws Exception
	{
		final URL myUrl = EhCache.class.getResource("ehcache3.xml");
		XmlConfiguration xmlConfig = new XmlConfiguration(myUrl);
		CacheManager myCacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);
	}

	/**
	 * 
	 */
	public static void test1()
	{
		CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
		// .withCache("preConfigured",
		// CacheConfigurationBuilder.newCacheConfigurationBuilder().buildConfig(Long.class,
		// String.class))
				.build(true);
		// Cache<Long, String> preConfigured =
		// cacheManager.getCache("preConfigured", Long.class, String.class);

		Cache<String, String> myCache = cacheManager.createCache("myCache",
				CacheConfigurationBuilder.newCacheConfigurationBuilder().buildConfig(String.class, String.class));
		myCache.put("name", "tangli .....");

		System.err.println(myCache.get("name"));

		cacheManager.close();
	}
	
	
}
