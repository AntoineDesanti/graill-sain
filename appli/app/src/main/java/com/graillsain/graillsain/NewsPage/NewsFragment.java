package com.graillsain.graillsain.NewsPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.graillsain.graillsain.Models.New;
import com.graillsain.graillsain.R;

public class NewsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.page_news, container, false);

        ListView lvNews = (ListView) rootView.findViewById(R.id.list_cards);
        NewsAdapter adapter = new NewsAdapter(getContext());

        lvNews.setAdapter(adapter);
        adapter.addAll(new New( R.drawable.michel, "La Ferme Michel", "Nouvel arrivage ! " +
                        "Venez découvrir nos paniers du mois de Mai, un mix de saveurs Printanières et Estivales garanties"),
                new New( R.drawable.nathalie, "Chez Nathalie", "Fermeture exceptionnelle du 19 au 25 Mai... N'hésitez pas à venir boire" +
                        "un verre au Bar d'en face"),
                new New(R.drawable.petit_potager, "Au petit Potager", "Offre spéciale! -35% sur l'ensemble des jus de légumes, " +
                        "et -50% sur les jus de fruits Bio ;)"));
        return rootView;
    }
}
