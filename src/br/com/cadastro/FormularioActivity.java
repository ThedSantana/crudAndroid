package br.com.cadastro;

import java.io.Serializable;

import br.com.cadastro.DAO.AlunoDAO;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class FormularioActivity extends Activity {

	private FormularioHelper helper;
	private Aluno alunoEdit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulario);

		final Button salvar = (Button) findViewById(R.id.btnSalvar);

		helper = new FormularioHelper(this);

		alunoEdit = (Aluno) getIntent().getSerializableExtra("alunoEdit");
		if(alunoEdit != null){
			helper.popularAluno(alunoEdit);
			salvar.setText("Alterar");
		}

		salvar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Aluno aluno = helper.getAlunoFormulario();
				AlunoDAO dao = new AlunoDAO(FormularioActivity.this);
				if (alunoEdit != null) {
					aluno.setId(alunoEdit.getId());
				    dao.editar(aluno);
				} else {
					dao.insere(aluno);
				}
				dao.close();
				Toast.makeText(FormularioActivity.this, "Registro salvo com sucesso!",
						Toast.LENGTH_SHORT).show();

				finish();

			}
		});

	}

}
