package filesys;

import java.util.Map;

import exception.CaminhoJaExistenteException;
import exception.CaminhoNaoEncontradoException;
import exception.PermissaoException;
import filesys.core.Offset;

// Essa classe deve servir apenas como proxy para o FileSystemImpl
final public class FileSystem implements IFileSystem {

    private final IFileSystem fileSystemImpl;

    public FileSystem(Map<String, Usuario> usuarios) {
        this.fileSystemImpl = new FileSystemImpl(usuarios);
    }

    @Override
    public void chmod(String caminho, String usuario, String usuarioAlvo, String permissao)
            throws CaminhoNaoEncontradoException, PermissaoException {
        fileSystemImpl.chmod(caminho, usuario, usuarioAlvo, permissao);
    }

    @Override
    public void mkdir(String caminho, String usuario)
            throws CaminhoJaExistenteException, PermissaoException, CaminhoNaoEncontradoException {
        fileSystemImpl.mkdir(caminho, usuario);
    }

    @Override
    public void rm(String caminho, String usuario, boolean recursivo)
            throws CaminhoNaoEncontradoException, PermissaoException {
        fileSystemImpl.rm(caminho, usuario, recursivo);
    }

    @Override
    public void touch(String caminho, String usuario)
            throws CaminhoJaExistenteException, CaminhoNaoEncontradoException, PermissaoException {
        fileSystemImpl.touch(caminho, usuario);
    }

    @Override
    public void write(String caminho, String usuario, boolean anexar, byte[] buffer)
            throws CaminhoNaoEncontradoException, PermissaoException {
        fileSystemImpl.write(caminho, usuario, anexar, buffer);
    }

    @Override
    public void read(String caminho, String usuario, byte[] buffer, Offset offset)
            throws CaminhoNaoEncontradoException, PermissaoException {
        fileSystemImpl.read(caminho, usuario, buffer, offset);
    }

    @Override
    public void mv(String caminhoAntigo, String caminhoNovo, String usuario)
            throws CaminhoNaoEncontradoException, PermissaoException, CaminhoJaExistenteException {
        fileSystemImpl.mv(caminhoAntigo, caminhoNovo, usuario);
    }

    @Override
    public void ls(String caminho, String usuario, boolean recursivo)
            throws CaminhoNaoEncontradoException, PermissaoException {
        fileSystemImpl.ls(caminho, usuario, recursivo);
    }

    @Override
    public void cp(String caminhoOrigem, String caminhoDestino, String usuario, boolean recursivo)
            throws CaminhoNaoEncontradoException, PermissaoException {
        fileSystemImpl.cp(caminhoOrigem, caminhoDestino, usuario, recursivo);
    }
}