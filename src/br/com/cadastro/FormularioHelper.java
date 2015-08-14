package br.com.cadastro;

import android.widget.EditText;
import android.widget.RatingBar;

public class FormularioHelper {
	
	private EditText campoNome;
	private EditText campoSite;
	private EditText campoEndereco;
	private EditText campoTelefone;
	private RatingBar campoNota;
	private Aluno aluno;

	public FormularioHelper(FormularioActivity activity) {
		aluno = new Aluno();
		
		campoNome = (EditText) activity.findViewById(R.id.nome);
		campoSite = (EditText) activity.findViewById(R.id.site);
		campoEndereco = (EditText) activity.findViewById(R.id.endereco);
		campoTelefone = (EditText) activity.findViewById(R.id.telefone);
		campoNota = (RatingBar) activity.findViewById(R.id.nota);
	}
	
	public Aluno getAlunoFormulario(){
		
		String nome = campoNome.getText().toString();
		String site = campoSite.getText().toString();
		String endereco = campoEndereco.getText().toString();
		String telefone = campoTelefone.getText().toString();
		int nota = campoNota.getProgress();
		
		aluno.setNome(nome);
		aluno.setSite(site);
		aluno.setEndereco(endereco);
		aluno.setTelefone(telefone);
		aluno.setNota(Double.valueOf(nota));
		
		return aluno;
	}

	public void popularAluno(Aluno alunoEdit) {
		campoNome.setText(alunoEdit.getNome());
		campoTelefone.setText(alunoEdit.getTelefone());
		campoEndereco.setText(alunoEdit.getEndereco());
		campoSite.setText(alunoEdit.getSite());
		campoNota.setRating(alunoEdit.getNota().floatValue());
	}

}
