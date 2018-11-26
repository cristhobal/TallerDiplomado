package com.latam.pax.nimbus.process.batchprocess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lanchile.framework.batch.BatchException;
import com.lanchile.framework.batch.BatchInfo;
import com.lanchile.framework.batch.Chunk;
import com.lanchile.framework.batch.Chunker;
import com.lanchile.framework.batch.CompositeChunk;
import com.lanchile.framework.batch.WorkDescriptor;
import com.latam.pax.nimbus.common.util.Constants;

public class ChunkerRobotMail implements Chunker{

	
	/**
	 * Clase que se encarga de generar los Threads a ejecutar en paralelo
	 */
	private static final long serialVersionUID = -4554314678995547480L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ChunkerRobotMail.class);
	
	@Override
	public Chunk getChunks(WorkDescriptor arg0) throws BatchException {
		CompositeChunk chunkList = new CompositeChunk(arg0, false);
		
		try {
			LOGGER.info("Inicializando generador de chunker...");

			chunkList = loadChunkList(arg0, chunkList);

			LOGGER.info("Generador de chunker ejecutado exitosamente!!!");
		} catch (Exception e) {
			LOGGER.error("El proceso nimbus no pudo terminar en forma exitosa", e);
			throw new BatchException(e);
		}
		return chunkList;
	}

	/**
	 * Metodo responsable de cargar los parametros necesarios para iniciar
	 * @param wd
	 * @param chunkList
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked" })
	private CompositeChunk loadChunkList(WorkDescriptor wd,
			CompositeChunk chunkList) throws BatchException {
		
		BatchInfo batchInfo = BatchInfo.getInstance();
		
		for(int i=1 ; i<=1; i++){
			batchInfo.addTotalChunkGenerated();
			WorkDescriptor chunkDescriptor = new WorkDescriptor(wd,"Chunk " + i);
			chunkDescriptor.put(Constants.CHUNK_SECUENCE,i);
			chunkList.addChunk(new Chunk(chunkDescriptor));
		}
		return chunkList;
	}
	
	
	@Override
	public Chunk getChunksTest(WorkDescriptor arg0) throws BatchException {
		return null;
	}

}
