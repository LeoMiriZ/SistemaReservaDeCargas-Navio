import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import javax.swing.JOptionPane;

public class Util {

	private Map<UUID, Empresa> t = new TreeMap<>();
	double c = 10000;

	public void menu() {

		int aux = 0;

		while (true) {

			aux = Integer.parseInt(JOptionPane.showInputDialog(
					"Sistema de Reserva de Cargas \n1. Reservar Carga \n2. Pesquisar Carga \n3. Imprimir Cargas Reservadas \n4. Excluir Carga \n5. Finalizar"));

			if (aux == 1) {

				reservar();

			} else if (aux == 2) {

				pesquisar();

			} else if (aux == 3) {

				listar();

			} else if (aux == 4) {

				excluir();

			} else if (aux == 5) {

				JOptionPane.showMessageDialog(null, "Operação finalizada com sucesso!");
				break;

			} else {

				JOptionPane.showMessageDialog(null, "Insira uma operação válida");

			}

		}

	}

	private void reservar() {

		String nome, destino, cnpj;
		double carga;

		nome = JOptionPane.showInputDialog("Insira o nome da empresa:");
		cnpj = JOptionPane.showInputDialog("Insira o CNPJ da empresa:");
		destino = JOptionPane.showInputDialog("Insira o destino da carga:");
		carga = Double.parseDouble(JOptionPane.showInputDialog("Insira o total da carga(em Kg)"));

		Empresa e = new Empresa();

		e.setNome(nome);
		e.setCarga(carga);
		e.setDestino(destino);
		e.setCnpj(cnpj);

		if (c - carga < 0) {

			JOptionPane.showMessageDialog(null, "Capacidade máxima do navio atingida!");
			JOptionPane.showMessageDialog(null, "Apenas cargas <= " + c + " Kg podem ser reservadas");

		} else {

			t.put(UUID.randomUUID(), e);
			c -= carga;
		}

	}

	private void pesquisar() {

		if (t.isEmpty()) {

			JOptionPane.showMessageDialog(null, "Não há cargas reservadas");

		} else {

			String cnpj = JOptionPane.showInputDialog("CNPJ para pesquisa:");

			for (Map.Entry<UUID, Empresa> l : t.entrySet()) {

				if (l.getValue().equals(new Empresa(cnpj))) {

					JOptionPane.showMessageDialog(null, "Código da carga: " + l.getKey() + "\n" + l.getValue());
					return;

				}

			}

			JOptionPane.showMessageDialog(null, "CNPJ não encontrado");

		}

	}

	private void listar() {

		if (t.isEmpty()) {

			JOptionPane.showMessageDialog(null, "Não há cargas reservadas");

		} else {

			for (Map.Entry<UUID, Empresa> l : t.entrySet()) {

				JOptionPane.showMessageDialog(null, "Código da carga: " + l.getKey() + "\n" + l.getValue());

			}

		}

	}

	private void excluir() {

		String cnpj = JOptionPane.showInputDialog("CNPJ para remoção:");

		for (Map.Entry<UUID, Empresa> l : t.entrySet()) {

			if (l.getValue().equals(new Empresa(cnpj))) {

				JOptionPane.showMessageDialog(null, "Código da carga: " + l.getKey() + "\n" + l.getValue());
				c += l.getValue().getCarga();
				t.remove(l.getKey());
				JOptionPane.showMessageDialog(null, "Carga removida com sucesso!");
				return;

			}

		}

		JOptionPane.showMessageDialog(null, "CNPJ não encontrado");

	}

}
