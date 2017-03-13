import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@ManagedBean(name = "json")
@ViewScoped
public class JSONBean {

	private List<ItemBean> items;

	@PostConstruct
	public void init() {

		String schema = "https://jsonplaceholder.typicode.com/users";
		
		try {
			Document data = Jsoup.connect(schema).ignoreContentType(true).get();
			String json = data.select("body").text();
			items = new Gson().fromJson(json, new TypeToken<List<ItemBean>>() {
			}.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<ItemBean> getItems() {
		return items;
	}

	public void setItems(List<ItemBean> items) {
		this.items = items;
	}

}
