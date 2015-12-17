package fucapi.br.pizzaria.controlado;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import fucapi.br.pizzaria.R;
import fucapi.br.pizzaria.bean.ProdutoBean;
import fucapi.br.pizzaria.bean.UsuarioBean;

/**
 * Created by fernando on 17/12/15.
 */
public class AdapterListView extends BaseAdapter {

    private LayoutInflater inflater;
    private List<ProdutoBean> item;

    public AdapterListView(Context context, List<ProdutoBean> item){
        this.item = item;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public ProdutoBean getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ItemSuporte itemHolder;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.modelo_lista,null);
            itemHolder = new ItemSuporte();
            itemHolder.txtTitulo = (TextView) convertView.findViewById(R.id.txtdesc);
            itemHolder.txtVl = (TextView) convertView.findViewById(R.id.txtvl);

            convertView.setTag(itemHolder);

            //99329-7455 sgt arantes
            //apdoc@comtax.com.br .. comprovante de pagamento
        }else{
            itemHolder = (ItemSuporte) convertView.getTag();
        }

        ProdutoBean itens = item.get(position);
        itemHolder.txtTitulo.setText(itens.getDescricao());
        itemHolder.txtVl.setText(itens.getValor());
        return convertView;
    }


}

class ItemSuporte{
    TextView txtTitulo;
    TextView txtVl;
}
